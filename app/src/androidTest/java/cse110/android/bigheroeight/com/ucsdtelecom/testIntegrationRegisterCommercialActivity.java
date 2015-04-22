package cse110.android.bigheroeight.com.ucsdtelecom;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Andrew on 2/24/2015.
 */
public class testIntegrationRegisterCommercialActivity extends ActivityInstrumentationTestCase2<RegisterCommercialActivity> {

    private Activity mActivity;
    private Instrumentation.ActivityMonitor monitor;

    public testIntegrationRegisterCommercialActivity(){
        super(RegisterCommercialActivity.class);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        setActivityInitialTouchMode(true);
    }

    /**
     * Method: testRegisterCommercialAllNullFields()
     * Purpose: Tests whether user is sent to LoginActivity because of null input. Test should
     * fail if user is sent to LoginActivity because they shouldn't be allowed
     */
    @MediumTest
    public void testRegisterCommercialAllNullFields() {

        // sets up monitor to listen for LoginActivity
        monitor = getInstrumentation().addMonitor(LoginActivity.class.getName(), null, false);

        // gets reference to currently open activity
        mActivity = getActivity();
        assertNotNull(mActivity);

        // sets up receiver for monitor
        Activity receiverActivity = null;

        // reference to sign up button
        Button button = (Button)mActivity.findViewById(R.id.button_03);

        TouchUtils.clickView(this, button);

        receiverActivity = monitor.waitForActivityWithTimeout(1000);

        // was the user sent to LoginActivity
        assertNull(receiverActivity);

        if ( receiverActivity != null )
            receiverActivity.finish();
    }

    /**
     * Method: testRegisterCommercialAllFieldsFilled()
     * Purpose: Tests whether user is sent to LoginActivity because of valid input. Test should
     * fail if user was not sent to LoginActivity because they entered valid input.
     */
    @MediumTest
    public void testRegisterCommercialAllFieldsFilled() {

        monitor = getInstrumentation().addMonitor(LoginActivity.class.getName(), null, false);

        mActivity = getActivity();
        assertNotNull(mActivity);


        mActivity.runOnUiThread(new Runnable() {
            public void run() {
                EditText businessName = (EditText)mActivity.findViewById(R.id.signup_businessname);
                EditText username = (EditText)mActivity.findViewById(R.id.signup_username);
                EditText password = (EditText)mActivity.findViewById(R.id.signup_password00);
                EditText retype = (EditText)mActivity.findViewById(R.id.signup_password01);
                EditText fName = (EditText)mActivity.findViewById(R.id.signup_firstname);
                EditText lName = (EditText)mActivity.findViewById(R.id.signup_lastname);
                EditText mName = (EditText)mActivity.findViewById(R.id.signup_middlename);
                EditText billFName = (EditText)mActivity.findViewById(R.id.signup_billing_firstname);
                EditText billMName = (EditText)mActivity.findViewById(R.id.signup_billing_middlename);
                EditText billLName = (EditText)mActivity.findViewById(R.id.signup_billing_lastname);
                EditText street = (EditText)mActivity.findViewById(R.id.signup_address);
                EditText city = (EditText)mActivity.findViewById(R.id.signup_city);
                EditText state = (EditText)mActivity.findViewById(R.id.signup_state);
                EditText zip = (EditText)mActivity.findViewById(R.id.signup_zip);
                EditText birth = (EditText)mActivity.findViewById(R.id.signup_birthday);
                EditText email = (EditText)mActivity.findViewById(R.id.signup_email);
                EditText cell = (EditText)mActivity.findViewById(R.id.signup_phonenum);

                businessName.requestFocus();
                businessName.setText("tester");
                username.requestFocus();
                username.setText("tester1");
                password.requestFocus();
                password.setText("tester");
                retype.requestFocus();
                retype.setText("tester");
                fName.requestFocus();
                fName.setText("tester");
                lName.requestFocus();
                lName.setText("tester");
                mName.requestFocus();
                mName.setText("tester");
                billFName.requestFocus();
                billFName.setText("tester");
                billMName.requestFocus();
                billMName.setText("tester");
                billLName.requestFocus();
                billLName.setText("tester");
                street.requestFocus();
                street.setText("tester");
                city.requestFocus();
                city.setText("tester");
                state.requestFocus();
                state.setText("tester");
                zip.requestFocus();
                zip.setText("00000");
                email.requestFocus();
                email.setText("tester1@gmail.com");
                birth.requestFocus();
                birth.setText("000000");
                cell.requestFocus();
                cell.setText("0000000000");
            }
        });

        Activity receiverActivity;

        Button button = (Button)mActivity.findViewById(R.id.button_03);

        TouchUtils.clickView(this, button);

        receiverActivity = monitor.waitForActivityWithTimeout(1000);

        // was the user sent to LoginActivity
        assertNotNull(receiverActivity);

        if (receiverActivity != null)
            receiverActivity .finish();
    }

    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
        if(mActivity != null) {
            mActivity.finish();
            mActivity = null;
        }
        if(monitor != null) {
            getInstrumentation().removeMonitor(monitor);
            monitor = null;
        }
    }

}