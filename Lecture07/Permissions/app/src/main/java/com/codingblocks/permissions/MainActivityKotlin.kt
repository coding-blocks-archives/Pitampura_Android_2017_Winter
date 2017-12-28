package com.codingblocks.permissions

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

/**
 * Created by arnav on 12/28/2017.
 */
class MainActivityKotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnWriteFile.setOnClickListener({
            when (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                PackageManager.PERMISSION_GRANTED ->
                    writeFile()

                PackageManager.PERMISSION_DENIED ->
                    ActivityCompat.requestPermissions(
                            this,
                            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                            44
                    )
            }
        })

        btnReadFile.setOnClickListener({
            when (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {

                PackageManager.PERMISSION_GRANTED ->
                    tvFileData.text = readFile()

                PackageManager.PERMISSION_DENIED ->
                    ActivityCompat.requestPermissions(
                            this,
                            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                            45
                    )
            }
        })

    }

    fun writeFile() {
        val helloTxt = File(Environment.getExternalStorageDirectory(), "hello.txt")
        helloTxt.appendText("Hello World")
    }

    fun readFile(): String {
        val helloTxt = File(Environment.getExternalStorageDirectory(), "hello.txt")
        return helloTxt.readText()
    }

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray) {

        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            when (requestCode) {
                44 -> writeFile()
                45 -> tvFileData.text = readFile()
            }
        } else {
            AlertDialog.Builder(this)
                    .setMessage("We need this permission to read/write files \n " +
                            "Please grant the permission")
                    .setPositiveButton("GIVE PERMISSION", {
                        dialog, i ->
                        ActivityCompat.requestPermissions(
                                this,
                                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                                45
                        )
                    })
                    .setNegativeButton("NO THANKS", {
                        dialog, i ->
                        Toast.makeText(this, "Sigh! I tried", Toast.LENGTH_SHORT).show()
                    })
                    .create()
                    .show()
        }
    }
}