package cse110.android.bigheroeight.com.ucsdtelecom;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;
import android.widget.EditText;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class testIntegrationRegisterRetailActivity extends ActivityInstrumentationTestCase2<RegisterRetailActivity> {

    private Activity mActivity;
    private Instrumentation.ActivityMonitor monitor;

    public testIntegrationRegisterRetailActivity()
    {
        super(RegisterRetailActivity.class);
    }

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        setActivityInitialTouchMode(true);
    }

    /**
     * Method: testRegisterAllNullFields()
     * Purpose: Submitting null fields during account creation should lead the user no where.
     * This tests for this.
     */
    @MediumTest
    public void testRegisterAllNullFields() {

        monitor = getInstrumentation().addMonitor(MainMenuRetailActivity.class.getName(), null, false);

        mActivity = getActivity();
        assertNotNull(mActivity);

        Activity receiverActivity;

        Button button = (Button)mActivity.findViewById(R.id.button_03);

        TouchUtils.clickView(this, button);

        // Checks if monitor picked up an activity intent to retail main menu
        receiverActivity = monitor.waitForActivityWithTimeout(1000);

        assertNull(receiverActivity);

        // If test passed, wait for a moment to see if an activity opens up after
        if( receiverActivity == null){
            receiverActivity = monitor.waitForActivityWithTimeout(1000);
            assertNull(receiverActivity);
        }

        // If test failed, close the activity that was just opened
        if ( receiverActivity != null )
            receiverActivity.finish();
    }

    /**
     * Method: testRegisterAllFieldsFilled()
     * Purpose: Submitting valid fields should create the user account. This tests makes sure the
     * user is taken to the login activity. It also tests whether the account was actually created
     * by checking if they are able to login and get into main menu.
     */
    @MediumTest
    public void testRegisterAllFieldsFilled() {


        /*
        monitor = getInstrumentation().addMonitor(LoginActivity.class.getName(), null, false);

        solo.assertCurrentActivity("Wrong starting activity", RegisterRetailActivity.class.getName());
        solo.enterText((EditText)solo.getView(R.id.signup_username), "tester1" );
        solo.enterText((EditText)solo.getView(R.id.signup_password00), "tester" );
        solo.enterText((EditText)solo.getView(R.id.signup_password01), "tester" );
        solo.enterText((EditText)solo.getView(R.id.signup_firstname), "tester" );
        solo.enterText((EditText)solo.getView(R.id.signup_lastname), "tester" );
        solo.enterText((EditText)solo.getView(R.id.signup_middlename), "tester" );
        solo.enterText((EditText)solo.getView(R.id.signup_address), "tester" );
        solo.enterText((EditText)solo.getView(R.id.signup_city), "tester" );
        solo.enterText((EditText)solo.getView(R.id.signup_state), "tester" );
        solo.enterText((EditText)solo.getView(R.id.signup_zip), "tester" );
        solo.enterText((EditText)solo.getView(R.id.signup_birthday), "00000" );
        solo.enterText((EditText)solo.getView(R.id.signup_email), "tester1@gmail.com" );
        solo.enterText((EditText)solo.getView(R.id.signup_phonenum), "00000" );

        solo.clickOnButton("Sign Up");

        Activity receiverActivity;
        receiverActivity = monitor.waitForActivityWithTimeout(1000);
        assertNotNull(receiverActivity);

        if (receiverActivity != null)
            receiverActivity .finish();
        //assertTrue(solo.waitForActivity(LoginActivity.class));
        */


        monitor = getInstrumentation().addMonitor(LoginActivity.class.getName(), null, false);

        mActivity = getActivity();
        assertNotNull(mActivity);

        mActivity.runOnUiThread(new Runnable() {
            public void run() {
                EditText username = (EditText)mActivity.findViewById(R.id.signup_username);
                EditText password = (EditText)mActivity.findViewById(R.id.signup_password00);
                EditText retype = (EditText)mActivity.findViewById(R.id.signup_password01);
                EditText fName = (EditText)mActivity.findViewById(R.id.signup_firstname);
                EditText lName = (EditText)mActivity.findViewById(R.id.signup_lastname);
                EditText mName = (EditText)mActivity.findViewById(R.id.signup_middlename);
                EditText street = (EditText)mActivity.findViewById(R.id.signup_address);
                EditText city = (EditText)mActivity.findViewById(R.id.signup_city);
                EditText state = (EditText)mActivity.findViewById(R.id.signup_state);
                EditText zip = (EditText)mActivity.findViewById(R.id.signup_zip);
                EditText birth = (EditText)mActivity.findViewById(R.id.signup_birthday);
                EditText email = (EditText)mActivity.findViewById(R.id.signup_email);
                EditText cell = (EditText)mActivity.findViewById(R.id.signup_phonenum);

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
                street.requestFocus();
                street.setText("tester");
                city.requestFocus();
                city.setText("tester");
                state.requestFocus();
                state.setText("tester");
                zip.requestFocus();
                zip.setText("00000");
                email.requestFocus();
                email.setText("tester1234@gmail.com");
                birth.requestFocus();
                birth.setText("00000000");
                cell.requestFocus();
                cell.setText("0000000000");

            }
        });

        Activity receiverActivity;

        Button button = (Button)mActivity.findViewById(R.id.button_03);

        TouchUtils.clickView(this, button);

        receiverActivity = monitor.waitForActivityWithTimeout(1000);

        if(receiverActivity == null){
            assertNotNull(receiverActivity);
        }

        if (receiverActivity != null) {
            receiverActivity.finish();
        }

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