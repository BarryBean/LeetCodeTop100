package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName:com.company
 * @ClassName:RobIII_337
 * @Description
 * @Author: yushengbi
 * @Date:2020/3/26 9:36
 */
public class RobIII_337 {
    Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }

        int rob = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int noRob = (root.left == null ? 0 : rob(root.left)) + (root.right == null ? 0 : rob(root.right));
        int res = Math.max(rob, noRob);
        map.put(root, res);
        return res;
    }
}
