package com.project.myprogress.modelclass;

import com.project.myprogress.R;



public enum TypeTask {

    Type1("Task goal",R.drawable.icon_type_goal_1),
    Type2("Task for complete goal",R.drawable.icon_type_sub_goal_2),
    Type3("Simple task",R.drawable.icon_type_3);

    public String name;
    public int icon;

    TypeTask(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }


    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }

    public static String getByName(int icon) {

        TypeTask item;
        if (icon != 0) {
            for (int i = 0; i < TypeTask.values().length; i++) {
                item = TypeTask.values()[i];
                if (item.getIcon() == icon) {
                    return item.getName();
                }
            }
        }
        return null;
    }
}
