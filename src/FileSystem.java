import java.util.*;

public class FileSystem {
    private Map<String, List<String>> rules;

    private Map<String, List<String>> childparentMap;
    private List<String> completedList;
    // Feel free to add more instance variables.

    public FileSystem(Map<String, List<String>> rules) {
        this.rules = rules;
        completedList = new ArrayList<String>();
        childparentMap = new HashMap<>();
    }

    /**
     * Returns targets to start building that are unblocked, with the end goal being
     * to build the passed in primary target.
     *
     * `startBuild()` is called by the client at the beginning of a build. It is
     * guaranteed to be called at most one time, before any calls to `onComplete()`.
     */
    public List<String> startBuild(String target) {
        List<String> dependencies = rules.get(target);
        List<String> res = new ArrayList<>();
        Set<String> resultSet = new HashSet<>();
        if(dependencies.size()==0){
            res.add(target);
            return res;
        }
        for(String dependency: dependencies){
            resultSet.addAll(startBuild(dependency));
        }
        // TODO: Implement.
        res.addAll(resultSet);
        return res;
    }

    /**
     * Returns targets to start building that are now unblocked due to the passed in
     * target having completed. The end goal is still to build the primary target
     * passed into the original `startBuild()` call.
     *
     * `onComplete()` is called whenever a target has finished building. It will
     * only be called once for each target, and will only be called for targets that
     * have previously been returned by `startBuild()` or other calls to `onComplete()`.
     */
    public List<String> onComplete(String target) {
        // TODO: Implement.
        completedList.add(target);
        List<String> dependencies;
        for(Map.Entry<String, List<String>> entry: rules.entrySet()){
            dependencies = entry.getValue();
            if(dependencies.contains(target)){
                for(String dependency: dependencies){
                    if(!completedList.contains(dependency)){
                        return Collections.emptyList();
                    }
                    List<String> parents = childparentMap.get(dependency)==null?new ArrayList<>():childparentMap.get(dependency);
                    parents.add(entry.getKey());
                    childparentMap.put(dependency,parents);
                }

            }

        }

        return childparentMap.get(target);
    }

    public static void main(String[] args) {
        Map<String, List<String>> rules = new HashMap<>();

        /**
         *           bin
         *          /   \
         *         /     \
         *      foo.o   bar.o   baz.o
         *       /  \    /  \    /
         *      /    \  /    \  /
         *   foo.c  utils.h  bar.c
         */
        rules.put("utils.h", new ArrayList<>());
        rules.put("foo.c", new ArrayList<>());
        rules.put("bar.c", new ArrayList<>());
        rules.put("baz.o", new ArrayList<>(Arrays.asList("bar.c")));
        rules.put("foo.o", new ArrayList<String>(Arrays.asList("foo.c", "utils.h")));
        rules.put("bar.o", new ArrayList<String>(Arrays.asList("bar.c", "utils.h")));
        rules.put("bin", new ArrayList<String>(Arrays.asList("foo.o", "bar.o")));
        // ... tens of thousands more targets

        FileSystem sol = new FileSystem(rules);
        assertListEqual("startBuild('bin')", sol.startBuild("bin"), Arrays.asList("utils.h", "foo.c", "bar.c"));
        assertListEqual("onComplete('foo.c')", sol.onComplete("foo.c"), Collections.emptyList());
        assertListEqual("onComplete('bar.c')", sol.onComplete("bar.c"), Collections.emptyList());
        assertListEqual("onComplete('utils.h')", sol.onComplete("utils.h"), Arrays.asList("bar.o", "foo.o"));
        assertListEqual("onComplete('foo.o')", sol.onComplete("foo.o"), Collections.emptyList());
        assertListEqual("onComplete('bar.o')", sol.onComplete("bar.o"), Arrays.asList("bin"));

        for (Map.Entry entry : sol.childparentMap.entrySet())
        {
            System.out.println("Parent map - key: " + entry.getKey() + "; value: " + entry.getValue());
        }
        System.out.println("End");
    }

    public static void assertListEqual(String testCaseName, List<String> lList, List<String> rList) {
        if (lList.size() != rList.size() ||
                !new HashSet<>(lList).equals(new HashSet<>(rList))) {
            System.out.println(
                    String.format("Test case %s: Expecting: (%s), but got: (%s)",
                            testCaseName,
                            String.join(", ", rList),
                            String.join(", ", lList)));
        }
    }
}