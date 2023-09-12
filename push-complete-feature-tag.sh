#!/bin/bash

CURRENT_BRANCH=$(git symbolic-ref --short HEAD)

# Replace / with -
TAG=$(echo "$CURRENT_BRANCH" | sed 's/\//-/g')

TAG_NAME="feature-completed-$TAG"
TAG_MESSAGE="Branch: $CURRENT_BRANCH"

git tag -a "$TAG_NAME" -m "$TAG_MESSAGE"

git push origin "$TAG_NAME"