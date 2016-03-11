package ado.com.testbondaction;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Ado on 11/03/16.
 */
public class BondStateReceiver extends BroadcastReceiver {
    private static final String TAG = "BondStateReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if(action.equals(BluetoothDevice.ACTION_BOND_STATE_CHANGED)) {
            final int extraBondState = intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE, -1);
            Log.d(TAG, "received BOND_STATE_CHANGED (" + extraBondState + ")");
            if(extraBondState == BluetoothDevice.BOND_BONDED) {
                Log.d(TAG, "bonded! starting activity");
                final BluetoothDevice extraDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                final String extraAddress = extraDevice.getAddress();
                final Context applicationContext = context.getApplicationContext();
                final Intent startActivity = new Intent(applicationContext, BondStateMainActivity.class);
                //required to start an activity from a non-activity context
                startActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity.putExtra(BondStateMainActivity.EXTRA_DEVICE_ADDRESS, extraAddress);
                applicationContext.startActivity(startActivity);
            }

        }
    }
}
