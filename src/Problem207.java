import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites给出，其中prerequisites[i]=[ai,bi]，
表示如果要学习课程 ai 则 必须 先学习课程  bi 。
例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。

输入：numCourses = 2, prerequisites = [[1,0]]
输出：true
解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。

输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
输出：false
解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 */
/*
思路：
bfs，每次将入度为0的点加入队列，弹出时将它指向的另一个节点的入度减一，最后看入队的节点数和n是否相等
 */
public class Problem207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] pre:prerequisites){
            edges.get(pre[1]).add(pre[0]);
            ++inDegree[pre[0]];
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()){
            ++visited;
            int u = queue.poll();
            for (int v:edges.get(u)){
                --inDegree[v];
                if (inDegree[v]==0){
                    queue.offer(v);
                }
            }
        }
        return visited == numCourses;
    }
}
