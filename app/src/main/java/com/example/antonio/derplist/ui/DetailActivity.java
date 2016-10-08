package com.example.antonio.derplist.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.antonio.derplist.R;

public class DetailActivity extends AppCompatActivity {
    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";
    private static final String EXTRA_ATTR = "EXTRA_ATTR";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle extras = getIntent().getBundleExtra(BUNDLE_EXTRAS);
//double brackets deixa-te definir uma a textview sem a definir a uma variavel - referenciada pelo findviewbyid
        ((TextView)findViewById(R.id.quote_text)).setText(extras.getString(EXTRA_QUOTE));
        ((TextView)findViewById(R.id.quote_attribute)).setText(extras.getString(EXTRA_ATTR));

    }
}
