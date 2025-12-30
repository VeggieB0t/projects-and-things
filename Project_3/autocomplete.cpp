//Brenden Harris
//07-27-2025
//CS:3358
//project 3




/*
 * autocomplete.cpp
 * 
 * The file where you will implement your autocomplete code for Project 4.
 *
 * INSTRUCTOR NOTE: Do not change any of the existing function signatures in
 * this file, or the testcases will fail. 
 */

#include "autocomplete.h"

/** QUESTION 1: FINDNODE **/

// EFFECTS: Traverses the Tree based on the charactes in the prefix and 
//          returns the TreeNode that we end at. If we cannot find a valid node,
//          we return an empty TreeNode. The index variable keeps track of what 
//          character we're at in prefix.
// 
// PSEUDOCODE:
// algorithm FindNode
//   Input: TreeNode node, string prefix, int index
//   Output: TreeNode representing the last character in prefix, or empty node
//   If index == length of prefix, return node
//   For each child in node.GetChildren()
//       If child.GetValue() == prefix[index]
//           Recursively call FindNode(child, prefix, index + 1)
//           Return result
//   If no child matches, return empty TreeNode
//
// COMMENTS:
// The idea behind this logic is to allow the tree to be traversed.
// We match nodes to child nodes and return the last node or empty if no match.
TreeNode<char> FindNode(TreeNode<char> node, std::string prefix, int index) {
  if (index == prefix.length()) {
    return node;
  }

  for (TreeNode<char>& child : node.GetChildren()) {
    if (child.GetValue() == prefix[index]) {
      return FindNode(child, prefix, index + 1);
    }
  }

  return TreeNode<char>(); // Return empty node if prefix can't be matched
}

/** QUESTION 2: COLLECTWORDS **/

// EFFECTS: Collects all the words starting from a given TreeNode. For each word, 
//          prepends the word with the prefix and adds it to the results vector.
// 
// PSEUDOCODE:
// algorithm CollectWords
//   Input: TreeNode node, string prefix, vector<string> &results
//   Output: none (results updated in place)
//   if node.GetValue() == '$':
//       add prefix to results
//       return
//   for each child in node.GetChildren():
//       recursively call CollectWords, appending child char (skip '$')
//
// COMMENTS:
// This code's logic allows for gathering words by DFS and handling '$' properly.
void CollectWords(TreeNode<char> node, std::string prefix, std::vector<std::string> &results) {
  if (node.GetValue() == '$') {  
    results.push_back(prefix);  // End of a word: add and stop
    return;
  }
  for (TreeNode<char>& child : node.GetChildren()) {
    if (child.GetValue() == '$') {
      CollectWords(child, prefix, results);  // End marker: add current word
    } else {
      CollectWords(child, prefix + child.GetValue(), results);  // Add letter and recurse
    }
  }
}

/** QUESTION 3: GETCANDIDATES **/

// EFFECTS: Returns the list of all possible words that can be made starting with
//          the letters in prefix, based on traversing the tree with the given root.
// 
// PSEUDOCODE:
// algorithm GetCandidates
//   Input: TreeNode root, string prefix
//   Output: vector<string> containing all words starting with prefix
//   1. Call FindNode(root, prefix, 0) and store the result in start_node
//   2. If start_node is empty (IsEmpty() == true):
//         return an empty vector (prefix not in tree)
//   3. Initialize an empty vector<string> results
//   4. Call CollectWords(start_node, prefix, results)
//   5. Return results
//
// COMMENTS:
// This code returns all words starting with the prefix by traversing the tree.
// The key is to pass the prefix to CollectWords so completed words include it.
std::vector<std::string> GetCandidates(TreeNode<char> root, std::string prefix) {
  TreeNode<char> start_node = FindNode(root, prefix, 0);

  std::vector<std::string> results;
  if (!start_node.IsEmpty()) {
    CollectWords(start_node, prefix, results);
  }

  return results;
}
