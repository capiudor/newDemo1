package day10_24;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @ClassName: DirList3
 * @description: TODO
 * @author: Capiudor
 * @Date: 2018/10/24 0:17
 * @Version: 1.0
 * @create: 2018-10-24 00:17
 **/

public class DirList3 {
    public static void main(String[] args) {
        File path = new File("src/day10_24");
        String[] list;
        if (args.length==0)
            list = path.list();
        else
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);
                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }

    /**
     * Output:
     *DirList.java
     * DirList2.java
     * DirList3.java
     * 笔记.txt
     */

    /**
     *  既然匿名内部类直接使用args[0]，那么传递给main()方法的参数现在就是final的。
     *  这个例子展示了匿名内部类怎样通过创建特定的、一次性的类来解决问题。
     *  此方法的一个优点就是讲解决特定问题的代码隔离、聚拢于一点。
     *  另一方面，这种方法却不已阅读，因此要谨慎使用。
     *
     *
     *
     * @练习
     *      1、修改DirList.java (或其变体之一)，以便FilenameFilter能够打开每个文件
     *      （使用net.mindview.util.TextFile工具），并检查命令行尾随的参数是否存在于那个文件中，一次来检查结果来决定是否接受这个文件。
     *      2、创建一个叫做SortedDirList的类，它具有一个可以接受文件路径信息，并能构建该路径下所有文件的排序目录列表的构造器。想这个类添加两个重载的list()方法：
     *          一个产生整个列表，一个产生与其参数（一个正则表达式）相匹配的列表的子集。
     *      3、修改DirList（或其变体之一），使其对所选中的文件计算文件尺寸的总和。
     */
}
