package com.codingblocks.ankorestapi

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.codingblocks.ankorestapi.activities.AlbumsActivity
import com.codingblocks.ankorestapi.activities.PostsActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    class MainActivityUI: AnkoComponent<Activity> {
        override fun createView(ui: AnkoContext<Activity>): View = with(ui) {
            verticalLayout {
                lparams(matchParent, matchParent)
                linearLayout {
                    lparams(matchParent, 0, 1F)
                    button("POSTS")
                            .lparams(0, matchParent, 1F)
                            .onClick {
                                startActivity<PostsActivity>()
                            }
                    button("ALBUM")
                            .lparams(0, matchParent, 1F)
                            .onClick {
                                startActivity<AlbumsActivity>()
                            }

                }
                linearLayout {
                    lparams(matchParent, 0, 1F)

                }
            }
        }

    }
}
