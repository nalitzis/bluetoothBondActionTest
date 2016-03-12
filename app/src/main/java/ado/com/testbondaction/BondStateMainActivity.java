package ado.com.testbondaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BondStateMainActivity extends AppCompatActivity {

    public static final String EXTRA_DEVICE_ADDRESS = "EXTRA_DEVICE_ADDRESS";
    public static final String EXTRA_PAIR_REQUEST = "EXTRA_PAIR_REQUEST";

    private String mBtAddressValue;
    private boolean mPairingRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bond_state_main);

        mBtAddressValue = getIntent().getStringExtra(EXTRA_DEVICE_ADDRESS);
        mPairingRequest = getIntent().getBooleanExtra(EXTRA_PAIR_REQUEST, false);
        TextView valueTv = (TextView)findViewById(R.id.bonded_address_value);
        valueTv.setText(mBtAddressValue);
        TextView valuePairTv = (TextView)findViewById(R.id.pair_request_value);
        valuePairTv.setText(""+ mPairingRequest);
    }
}
