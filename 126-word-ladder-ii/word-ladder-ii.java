class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return new ArrayList<>();

        Map<String, List<String>> parents = new HashMap<>();
        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(beginWord);
        Set<String> visited = new HashSet<>();
        boolean found = false;

        while (!currentLevel.isEmpty() && !found) {
            Set<String> nextLevel = new HashSet<>();
            visited.addAll(currentLevel);

            for (String word : currentLevel) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char original = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        chs[i] = c;
                        String nextWord = new String(chs);
                        if (!wordSet.contains(nextWord) || visited.contains(nextWord)) continue;

                        if (!parents.containsKey(nextWord)) {
                            parents.put(nextWord, new ArrayList<>());
                        }
                        parents.get(nextWord).add(word);

                        if (nextWord.equals(endWord)) found = true;
                        nextLevel.add(nextWord);
                    }
                    chs[i] = original;
                }
            }
            currentLevel = nextLevel;
        }

        List<List<String>> res = new ArrayList<>();
        if (found) {
            List<String> path = new LinkedList<>();
            backtrack(endWord, beginWord, parents, path, res);
        }
        return res;
    }

    private void backtrack(String word, String beginWord, Map<String, List<String>> parents,
                           List<String> path, List<List<String>> res) {
        if (word.equals(beginWord)) {
            path.add(0, word);
            res.add(new ArrayList<>(path));
            path.remove(0);
            return;
        }

        if (!parents.containsKey(word)) return;

        path.add(0, word);
        for (String parent : parents.get(word)) {
            backtrack(parent, beginWord, parents, path, res);
        }
        path.remove(0);
    }
}