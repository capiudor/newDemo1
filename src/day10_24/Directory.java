package day10_24;


import java.io.File;
import java.io.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.regex.Pattern;


/**
 * @ClassName: Directory
 * @description: TODO
 * @author: Capiudor
 * @Date: 2018/10/24 1:06
 * @Version: 1.0
 * @create: 2018-10-24 01:06
 **/

public final class Directory {
    public static File[]
        local(File dir,final String regex){
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
    }
    public static File[]
    local(String path,final String regex){
        //Overload
        return local(path,regex);
    }
    // a two-tuple for returning a pair of objects:
    public static class TreeInfo implements Iterable<File>{
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();
        //the define iterable elements iterable<File>
        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        public String toString(){
            return "dirs: " + PPrint.pformat(dirs)+"\n\nfiles: " + PPrint.pformat(files);
        }

        @Override
        public void forEach(Consumer<? super File> action) {

        }

        @Override
        public Spliterator<File> spliterator() {
            return null;
        }
    }
}
