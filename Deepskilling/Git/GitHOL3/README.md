git checkout -b GitWork

echo "Branch Content" > hello.xml

git add .

git commit -m "Updated hello.xml in GitWork"

git checkout main

echo "Main Content" > hello.xml

git add .

git commit -m "Updated hello.xml in main"

git merge GitWork

# Resolve conflict

git add hello.xml

git commit -m "Resolved Merge Conflict"

git branch -d GitWork