package day10_24;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @ClassName: DirList2
 * @description: TODO
 * @author: Capiudor
 * @Date: 2018/10/24 0:03
 * @Version: 1.0
 * @create: 2018-10-24 00:03
 **/

public class DirList2 {
    /**
     * @Author Capiudor
     * @Description //TODO 这个final String regex 的参数
     *               //todo   （准确的说是传向filter()的参数必须是final的）必须是final的，
     *               todo   在匿名内部类中是必须的，这样它餐能够使用来自该类范围之外的对象。
     * @Date 0:13 2018/10/24
     * @Param [regex]
     * @return java.io.FilenameFilter
     **/
    public static FilenameFilter filter(final String regex){

        //Creation of anonymous inner class;
        return  new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };//End of anonymous inner class
    }

    public static void main(String[] args) {
        File path = new File("src/day10_24");
        String[] list;
        if (args.length==0)
            list = path.list();
        else
            list = path.list(filter(args[0]));
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String dirItem :list) {
            System.out.println(dirItem);
        }
    }/**Output:
     DirList.java
     DirList2.java
     笔记.txt
        **
     *
     * 这个设计有所改进，因为现在FilenameFilter类紧密地和DirList2绑定在一起。
     * 然而，我们可以进一步修改该方法，定义一个作为list()参数的匿名内部类；
     * 这样一来程序会变得更小
     * */
}

