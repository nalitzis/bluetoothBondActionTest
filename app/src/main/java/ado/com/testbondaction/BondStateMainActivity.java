package ado.com.testbondaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BondStateMainActivity extends AppCompatActivity {

    public static final String EXTRA_DEVICE_ADDRESS = "EXTRA_DEVICE_ADDRESS";

    private String mBtAddressValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bond_state_main);

        mBtAddressValue = getIntent().getStringExtra(EXTRA_DEVICE_ADDRESS);
        TextView valueTv = (TextView)findViewById(R.id.bonded_address_value);
        valueTv.setText(mBtAddressValue);
    }
}
