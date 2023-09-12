#!/bin/bash

CURRENT_BRANCH=$(git symbolic-ref --short HEAD)

TAG_NAME="feature-completed-$CURRENT_BRANCH"
TAG_MESSAGE="Branch: $CURRENT_BRANCH"

git tag -a "$TAG_NAME" -m "$TAG_MESSAGE"

git push origin "$TAG_NAME"