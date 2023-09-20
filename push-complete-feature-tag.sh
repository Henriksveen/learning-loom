#!/bin/bash

validate_branch_name() {
    local branch_name="$1"
    local pattern="^[a-zA-Z0-9-]+\/(feature|hotfix)\/#[0-9]+\/[a-z0-9-]+$"

    if [[ $branch_name =~ $pattern ]]; then
        return 0
    else
        echo "Branch name: '$branch_name' does not follow the convention. It should match the pattern:"
        echo "Author/(feature/hotfix)/#ReleaseNumber/Description"
        echo "Example: sh/feature/#123/new-feature"
        exit 1
    fi
}

CURRENT_BRANCH=$(git symbolic-ref --short HEAD)

if ! validate_branch_name "$CURRENT_BRANCH"; then
    exit 1
fi

# Replace / with -
TAG=$(echo "$CURRENT_BRANCH" | sed 's/\//-/g')

TAG_NAME="feature-completed-$TAG"
TAG_MESSAGE="Branch: $CURRENT_BRANCH"

git tag -a "$TAG_NAME" -m "$TAG_MESSAGE"

git push origin "$TAG_NAME"