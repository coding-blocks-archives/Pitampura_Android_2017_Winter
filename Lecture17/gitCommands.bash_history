10361  mkdir GitIntro
10362  cd GitIntro
10363  sublime .
10364  git init .
10365  git status
10366  git add -A
10367  git commit
10368  git commit
10369  git log
10370  git config --global --list
10371  git status
10372  git add -A
10373  git status
10374  git commit -m "add hw and line4 to file1"
10375  git status
10376  git commit -am 'line5'
10377  git status
10378  git log
10379  git branch
10380  git branch bugfix
10381  git branch
10382  git checkout bugfix
10383  git branch
10384  git commit -sam "added lines 3.1, 3.2"
10385  git commit --amend
10386  git commit -sam "add world"
10387  git log --oneline
10388  git checkout master
10389  git log --oneline
10390  git log --oneline --all
10391  git branch
10392  git add -A
10393  git commit -sm "added lines 3.1, 3.1.1"
10394  git log --oneline --all
10395  git log --oneline --all --color --graph --decorate
10396  git config --global --list
10397  git fulltree
10398  git status
10399  git diff
10400  git add -A
10401  git diff
10402  git commit -sm "add awesome"
10403  git log --oneline
10404  git diff 7a0fc52
10405  git diff 7a0fc52 HEAD
10406  git log --oneline
10407  git diff 3c8cba8 3adfaa9
10408  git diff 3adfaa9 3c8cba8
10409  git log --oneline
10410  git diff abe4f25 7a0fc52
10411  git fulltree
10412  git checkout 3adfaa9
10413  git fulltree
10414  touch AnotherFile.txt
10415  git status
10416  git add -A
10417  git commit -sm 'another file'
10418  git fulltree
10419  git checkout master
10420  git fulltree
10421  git checkout bugfix
10422  git branch hotfix
10423  git fulltree
10424  git checkout 55c8a22
10425  git fulltree
10426  git branch -f bugfix
10427  git fulltree
10428  git checkout master
10429  git fulltree
10430  git log --oneline hotfix
10431  git merge hotfix
10432  git status
10433  git add -A
10434  git status
10435  git commit
10436  git fulltree
10437  git diff hotfix master
10438  git fulltree
10439  git log 590eee3 --oneline
10440  git checkout 590eee3
10441  git checkout master
10442  git log --oneline
10443  git commit -sam "more changes"
10444  git fulltree
10445  git cherry-pick 590eee3
10446  git  merge --abort
10447  git status
10448  git stash
10449  git status
10450  git reset
10451  git stash
10452  git stash clear
10453  git status
10454  git fulltree
10455  git merge --abort
10456  git commit -sam "dont ask how're you"
10457  git cherry-pick 590eee3
10458  git status
10459  git fulltree
10460  git checkout d853107
10461  git branch -f master
10462  git checkout master
10463  git fulltree
10464  git cherry-pick 590eee3
10465  git fulltree
10466  cd Development/CodingBlocks/NodeJS/oneauth
10467  git checkout master
10468  wget https://patch-diff.githubusercontent.com/raw/coding-blocks/oneauth/pull/115.patch
10469  ls
10470  git apply 115.patch
10471  git log --oneline
10472  git status
10473  git commit
10474  git add -A
10475  git commit
10476  git reset
10477  git stash
10478  git stash clear
10479  git status
10480  git clean -f
10481  git status
10482  wget https://patch-diff.githubusercontent.com/raw/coding-blocks/oneauth/pull/115.patch
10483  git am 115.patch
10484  git log --oneline
10485  git checkout refactor_
10486  git checkout refactor_cleanup_routers
10487  git fulltree
10488  touch a
10489  nano a
10490  git add a
10491  rm -rf a
