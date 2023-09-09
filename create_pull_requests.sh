#!/bin/bash

# GitHub repository details
repository_owner="Henriksveen"     # Replace with your GitHub username or organization name
repository_name="learning-loom"    # Replace with your repository name
access_token="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"   # Replace with your GitHub personal access token

# Define the base URL for GitHub API
base_url="https://api.github.com/repos/$repository_owner/$repository_name"

# Create a new branch for your feature
current_branch=$(git symbolic-ref --short HEAD)  # Replace with your feature branch name

# Create a PR title and body
pr_title="Feature: Your Feature Title"
pr_body="Description of your feature and any relevant details."

# Define the head and base branches for your PRs
head_test="$current_branch"
base_test="test"
head_prod="$current_branch"
base_prod="main"

# Function to create a PR
create_pr() {
  local base="$1"
  local head="$2"
  local title="$3"
  local body="$4"
  pr_data="{\"title\":\"$title\",\"body\":\"$body\",\"head\":\"$head\",\"base\":\"$base\"}"
  echo "$pr_data"
  local response
  response=$(curl -s -X POST "$base_url/pulls" -H "Authorization: token $access_token" -H "Accept: application/vnd.github.v3+json" -d "$pr_data")

  echo "$response"
}

# Create PR to test branch
create_pr "$base_test" "$head_test" "$pr_title" "$pr_body"
test_pr_response=$(create_pr "$base_test" "$head_test" "$pr_title" "$pr_body")
test_pr_url=$(echo "$test_pr_response" | jq -r '.html_url')
echo "PR to Test created: $test_pr_url"

# Create PR to prod branch
prod_pr_response=$(create_pr "$base_prod" "$head_prod" "$pr_title" "$pr_body")
prod_pr_url=$(echo "$prod_pr_response" | jq -r '.html_url')
echo "PR to Prod created: $prod_pr_url"
