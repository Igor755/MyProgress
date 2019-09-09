package com.project.myprogress.modelclass;

import com.project.myprogress.R;

public enum  StateTask {


    State1( R.drawable.galochka_grey40),
    State2(R.drawable.galochka_green40),
    State3(R.drawable.krest_on_red40);

    public int icon;

    StateTask( int icon) {
        this.icon = icon;
    }


    public int getIcon() {
        return icon;
    }
}




