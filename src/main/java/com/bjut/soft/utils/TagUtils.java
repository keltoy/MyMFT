package com.bjut.soft.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toy on 03/12/2016.
 */
public class TagUtils {

    private static final TagUtils instance = new TagUtils();

    private class TagInfo {
        private String name;
        private int index;
        private String content;
        public TagInfo(String name, int index, String content) {
            this.name = name;
            this.index = index;
            this.content = content;
        }
        public TagInfo(String name, int index) {
            this(name, index, null);
        }
    }

    private List<TagInfo> path;
    private int index;


    public static TagUtils getPath() {
        return instance;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (TagInfo each: path) {
            sb.append(each.name);
            if (each.content != null) {
                sb.append('{');
                sb.append(each.content);
                sb.append('}');
            }
            sb.append('/');
        }
        String res = sb.toString();
        return res;
    }

    public void addToPath(String step) {
        addToPath(step, null);
    }
    public void addToPath(String step, String content) {
        TagInfo info = new TagInfo(step, index, content);
        path.add(info);
        index++;
    }

    public void removeToPath() {
        path.remove(--index);
    }

    private TagUtils() {
        index = 0;
        path = new ArrayList<>();
    }
}
