package com.sun.toy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class howtouse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howtouse);

        TabHost host = (TabHost)findViewById(R.id.host);
        host.setup();

        TabHost.TabSpec spec = host.newTabSpec("tab1");
        spec.setIndicator("STEP.1");
        spec.setContent(R.id.tab1);
        host.addTab(spec);

        spec = host.newTabSpec("ta21");
        spec.setIndicator("STEP.2");
        spec.setContent(R.id.tab2);
        host.addTab(spec);

        spec = host.newTabSpec("tab3");
        spec.setIndicator("STEP.3");
        spec.setContent(R.id.tab3);
        host.addTab(spec);

        spec = host.newTabSpec("tab4");
        spec.setIndicator("STEP.4");
        spec.setContent(R.id.tab4);
        host.addTab(spec);
    }
}
