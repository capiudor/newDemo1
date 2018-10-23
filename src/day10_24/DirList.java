package day10_24;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirList {

    /**
     * @Author Capiudor
     * @Description //TODO 通过java.utils.Arrays.sort()和String.CASE_INSENSITIVE.ORDERComparator,可以很容易的对结果进行排序（按字母排序）
     *                      io/DirList.java
     *                      Display a directory listing using regular expressions.
     * @Date 23:43 2018/10/23
     * @Param
     * @return
     **/

    /**
     * @Author Capiudor
     * @Description //TODO 如果方法main()方法中的参数args如果为空
     * @Date 23:38 2018/10/23
     * @Param [args]
     * @return void
     **/
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length==0)
            list = path.list();
        else
            list = path.list(new DirFilter(args[0]));
    }

}
class DirFilter implements FilenameFilter{

    private Pattern pattern;
    public DirFilter(String regex){
        pattern = Pattern.compile(regex);
    }

    /**
     * @Author Capiudor
     * @Description //TODO
     * @Date 23:41 2018/10/23
     * @Param [dir, name]
     * @return boolean
     **/
    @Override
    public boolean accept(File dir, String name) {

        return pattern.matcher(name).matches();
    }
}
