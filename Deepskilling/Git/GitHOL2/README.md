git checkout -b GitNewBranch

echo "Hello Git" > hello.xml

git add hello.xml

git commit -m "Added hello.xml"

git status

git checkout main

git diff GitNewBranch

git merge GitNewBranch

git branch -d GitNewBranch