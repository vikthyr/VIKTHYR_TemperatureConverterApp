package com.vikthyr.temperatureconverter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    private ToggleButton fromCelsius, toCelsius;
    private ToggleButton fromFahrenheit, toFahrenheit;
    private ToggleButton fromKelvin, toKelvin;
    private ToggleButton fromReaumur, toReaumur;
    private ToggleButton fromRankine, toRankine;
    private ToggleButton fromNewton, toNewton;
    private ToggleButton fromDelisle, toDelisle;
    private ToggleButton fromRomer, toRomer;
    private EditText text_toConvertValue;
    private TextView text_result;
    private ImageButton btn_copyResult, btn_viewFormula, btn_clearAll, btn_invertConversion;
    private ToggleButton[] from_scaleButtons, to_scaleButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        btn_copyResult = findViewById(R.id.btn_copyResult);
        btn_viewFormula = findViewById(R.id.btn_viewFormula);
        btn_clearAll = findViewById(R.id.btn_clearAll);
        btn_invertConversion = findViewById(R.id.btn_invertConversion);


        //--------------CELSIUS--------------//
        fromCelsius = findViewById(R.id.btn_fromCelsius);
        toCelsius = findViewById(R.id.btn_toCelsius);
        fromCelsius.setOnCheckedChangeListener(changeChecker);
        toCelsius.setOnCheckedChangeListener(changeChecker);

        //--------------FAHRENHEIT--------------//
        fromFahrenheit = findViewById(R.id.btn_fromFahrentheit);
        toFahrenheit = findViewById(R.id.btn_toFahrentheit);
        fromFahrenheit.setOnCheckedChangeListener(changeChecker);
        toFahrenheit.setOnCheckedChangeListener(changeChecker);

        //--------------KELVIN--------------//
        fromKelvin = findViewById(R.id.btn_fromKelvin);
        toKelvin = findViewById(R.id.btn_toKelvin);
        fromKelvin.setOnCheckedChangeListener(changeChecker);
        toKelvin.setOnCheckedChangeListener(changeChecker);

        //--------------RÉAUMUR--------------//
        fromReaumur = findViewById(R.id.btn_fromReaumur);
        toReaumur = findViewById(R.id.btn_toReaumur);
        fromReaumur.setOnCheckedChangeListener(changeChecker);
        toReaumur.setOnCheckedChangeListener(changeChecker);

        //--------------RANKINE--------------//
        fromRankine = findViewById(R.id.btn_fromRankine);
        toRankine = findViewById(R.id.btn_toRankine);
        fromRankine.setOnCheckedChangeListener(changeChecker);
        toRankine.setOnCheckedChangeListener(changeChecker);

        //--------------NEWTON--------------//
        fromNewton = findViewById(R.id.btn_fromNewton);
        toNewton = findViewById(R.id.btn_toNewton);
        fromNewton.setOnCheckedChangeListener(changeChecker);
        toNewton.setOnCheckedChangeListener(changeChecker);

        //--------------DELISLE--------------//
        fromDelisle = findViewById(R.id.btn_fromDelisle);
        toDelisle = findViewById(R.id.btn_toDelisle);
        fromDelisle.setOnCheckedChangeListener(changeChecker);
        toDelisle.setOnCheckedChangeListener(changeChecker);

        //--------------ROMER--------------//
        fromRomer = findViewById(R.id.btn_fromRomer);
        toRomer = findViewById(R.id.btn_toRomer);
        fromRomer.setOnCheckedChangeListener(changeChecker);
        toRomer.setOnCheckedChangeListener(changeChecker);

        //--------------TEXTS--------------//
        text_toConvertValue = findViewById(R.id.text_toConvertValue);
        text_result = findViewById(R.id.text_result);

        from_scaleButtons = new ToggleButton[]{
                fromCelsius,
                fromFahrenheit,
                fromKelvin,
                fromReaumur,
                fromRankine,
                fromNewton,
                fromDelisle,
                fromRomer
        };

        to_scaleButtons = new ToggleButton[]{
                toCelsius,
                toFahrenheit,
                toKelvin,
                toReaumur,
                toRankine,
                toNewton,
                toDelisle,
                toRomer
        };



        text_toConvertValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!text_toConvertValue.getText().toString().isEmpty()) {
                    text_result.setText(String.valueOf(CalculateTemperature(text_toConvertValue.getText().toString())));
                } else {
                    text_result.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btn_copyResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text_result.getText().toString().length() != 0){
                    ClipboardManager clipboard = (ClipboardManager)getApplicationContext().getSystemService(getApplicationContext().CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("", text_result.getText());
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.toast_copiedToClipboard), Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.toast_resultIsEmpty), Toast.LENGTH_LONG).show();
                }


            }
        });

        btn_viewFormula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fromScale = "";
                String toScale = "";
                String formula = "";
                String fromSufix = "";
                String toSufix = "";
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                if(fromCelsius.isChecked()){
                    fromScale = fromCelsius.getText().toString();
                    fromSufix = getResources().getString(R.string.celsius_sufix);
                }
                if(fromFahrenheit.isChecked()){
                    fromScale = fromFahrenheit.getText().toString();
                    fromSufix = getResources().getString(R.string.fahrenheit_sufix);
                }
                if(fromKelvin.isChecked()){
                    fromScale = fromKelvin.getText().toString();
                    fromSufix = getResources().getString(R.string.kelvin_sufix);
                }
                if(fromReaumur.isChecked()){
                    fromScale = fromReaumur.getText().toString();
                    fromSufix = getResources().getString(R.string.reaumur_sufix);
                }
                if(fromRankine.isChecked()){
                    fromScale = fromRankine.getText().toString();
                    fromSufix = getResources().getString(R.string.rankine_sufix);
                }
                if(fromNewton.isChecked()){
                    fromScale = fromNewton.getText().toString();
                    fromSufix = getResources().getString(R.string.newton_sufix);
                }
                if(fromDelisle.isChecked()){
                    fromScale = fromDelisle.getText().toString();
                    fromSufix = getResources().getString(R.string.delisle_sufix);
                }
                if(fromRomer.isChecked()){
                    fromScale = fromRomer.getText().toString();
                    fromSufix = getResources().getString(R.string.romer_sufix);
                }
                if(toCelsius.isChecked()){
                    toScale = toCelsius.getText().toString();
                    toSufix = getResources().getString(R.string.celsius_sufix);
                }
                if(toFahrenheit.isChecked()){
                    toScale = toFahrenheit.getText().toString();
                    toSufix = getResources().getString(R.string.fahrenheit_sufix);
                }
                if(toKelvin.isChecked()){
                    toScale = toKelvin.getText().toString();
                    toSufix = getResources().getString(R.string.kelvin_sufix);
                }
                if(toReaumur.isChecked()){
                    toScale = toReaumur.getText().toString();
                    toSufix = getResources().getString(R.string.reaumur_sufix);
                }
                if(toRankine.isChecked()){
                    toScale = toRankine.getText().toString();
                    toSufix = getResources().getString(R.string.rankine_sufix);
                }
                if(toNewton.isChecked()){
                    toScale = toNewton.getText().toString();
                    toSufix = getResources().getString(R.string.newton_sufix);
                }
                if(toDelisle.isChecked()){
                    toScale = toDelisle.getText().toString();
                    toSufix = getResources().getString(R.string.delisle_sufix);
                }
                if(toRomer.isChecked()){
                    toScale = toRomer.getText().toString();
                    toSufix = getResources().getString(R.string.romer_sufix);
                }


                formula = TemperatureCalculator.getFormula(fromScale, toScale);

                if(fromScale.isEmpty() || toScale.isEmpty()){
                    builder.setTitle(getResources().getString(R.string.formula_info_title));
                    builder.setMessage(getResources().getString(R.string.formula_info_message));
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }else{
                    builder.setTitle(fromScale+" ("+fromSufix+")"+" -> "+toScale+" ("+toSufix+")");
                    builder.setMessage(formula);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }




            }
        });

        btn_clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fromCelsius.setChecked(false);
                fromFahrenheit.setChecked(false);
                fromKelvin.setChecked(false);
                fromReaumur.setChecked(false);
                fromRankine.setChecked(false);
                fromNewton.setChecked(false);
                fromDelisle.setChecked(false);
                fromRomer.setChecked(false);
                toCelsius.setChecked(false);
                toFahrenheit.setChecked(false);
                toKelvin.setChecked(false);
                toReaumur.setChecked(false);
                toRankine.setChecked(false);
                toNewton.setChecked(false);
                toDelisle.setChecked(false);
                toRomer.setChecked(false);
                text_toConvertValue.setText("");
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.toast_conversionRedefined), Toast.LENGTH_LONG).show();
            }
        });

        btn_invertConversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean from_isChecked = false;
                boolean to_isChecked = false;
                int from = 0;
                int to = 0;


                for (int i = 0; i < from_scaleButtons.length; i++) {
                    if (from_scaleButtons[i].isChecked()) {
                        from = i;
                        from_isChecked = true;
                        for (int y = 0; y < to_scaleButtons.length; y++) {
                            if (to_scaleButtons[y].isChecked()) {
                                to = y;
                                to_isChecked = true;
                            }
                        }
                    }
                }

                if(from_isChecked && to_isChecked) {
                    from_scaleButtons[to].setChecked(true);
                    to_scaleButtons[from].setChecked(true);
                }
            }
        });
    }

    CompoundButton.OnCheckedChangeListener changeChecker = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton button, boolean isChecked) {
            if (isChecked) {
                //--------------FROM--------------//
                if (button == fromCelsius) {
                    fromFahrenheit.setChecked(false);
                    fromKelvin.setChecked(false);
                    fromReaumur.setChecked(false);
                    fromRankine.setChecked(false);
                    fromNewton.setChecked(false);
                    fromDelisle.setChecked(false);
                    fromRomer.setChecked(false);
                }
                if (button == fromFahrenheit) {
                    fromCelsius.setChecked(false);
                    fromKelvin.setChecked(false);
                    fromReaumur.setChecked(false);
                    fromRankine.setChecked(false);
                    fromNewton.setChecked(false);
                    fromDelisle.setChecked(false);
                    fromRomer.setChecked(false);
                }
                if (button == fromKelvin) {
                    fromFahrenheit.setChecked(false);
                    fromCelsius.setChecked(false);
                    fromReaumur.setChecked(false);
                    fromRankine.setChecked(false);
                    fromNewton.setChecked(false);
                    fromDelisle.setChecked(false);
                    fromRomer.setChecked(false);
                }
                if (button == fromReaumur) {
                    fromFahrenheit.setChecked(false);
                    fromKelvin.setChecked(false);
                    fromCelsius.setChecked(false);
                    fromRankine.setChecked(false);
                    fromNewton.setChecked(false);
                    fromDelisle.setChecked(false);
                    fromRomer.setChecked(false);
                }
                if (button == fromRankine) {
                    fromFahrenheit.setChecked(false);
                    fromKelvin.setChecked(false);
                    fromReaumur.setChecked(false);
                    fromCelsius.setChecked(false);
                    fromNewton.setChecked(false);
                    fromDelisle.setChecked(false);
                    fromRomer.setChecked(false);
                }
                if (button == fromNewton) {
                    fromFahrenheit.setChecked(false);
                    fromKelvin.setChecked(false);
                    fromReaumur.setChecked(false);
                    fromRankine.setChecked(false);
                    fromCelsius.setChecked(false);
                    fromDelisle.setChecked(false);
                    fromRomer.setChecked(false);
                }
                if (button == fromDelisle) {
                    fromFahrenheit.setChecked(false);
                    fromKelvin.setChecked(false);
                    fromReaumur.setChecked(false);
                    fromRankine.setChecked(false);
                    fromNewton.setChecked(false);
                    fromCelsius.setChecked(false);
                    fromRomer.setChecked(false);
                }
                if (button == fromRomer) {
                    fromFahrenheit.setChecked(false);
                    fromKelvin.setChecked(false);
                    fromReaumur.setChecked(false);
                    fromRankine.setChecked(false);
                    fromNewton.setChecked(false);
                    fromDelisle.setChecked(false);
                    fromCelsius.setChecked(false);
                }
                //--------------TO--------------//
                if (button == toCelsius) {
                    toFahrenheit.setChecked(false);
                    toKelvin.setChecked(false);
                    toReaumur.setChecked(false);
                    toRankine.setChecked(false);
                    toNewton.setChecked(false);
                    toDelisle.setChecked(false);
                    toRomer.setChecked(false);
                }
                if (button == toFahrenheit) {
                    toCelsius.setChecked(false);
                    toKelvin.setChecked(false);
                    toReaumur.setChecked(false);
                    toRankine.setChecked(false);
                    toNewton.setChecked(false);
                    toDelisle.setChecked(false);
                    toRomer.setChecked(false);
                }
                if (button == toKelvin) {
                    toFahrenheit.setChecked(false);
                    toCelsius.setChecked(false);
                    toReaumur.setChecked(false);
                    toRankine.setChecked(false);
                    toNewton.setChecked(false);
                    toDelisle.setChecked(false);
                    toRomer.setChecked(false);
                }
                if (button == toReaumur) {
                    toFahrenheit.setChecked(false);
                    toKelvin.setChecked(false);
                    toCelsius.setChecked(false);
                    toRankine.setChecked(false);
                    toNewton.setChecked(false);
                    toDelisle.setChecked(false);
                    toRomer.setChecked(false);
                }
                if (button == toRankine) {
                    toFahrenheit.setChecked(false);
                    toKelvin.setChecked(false);
                    toReaumur.setChecked(false);
                    toCelsius.setChecked(false);
                    toNewton.setChecked(false);
                    toDelisle.setChecked(false);
                    toRomer.setChecked(false);
                }
                if (button == toNewton) {
                    toFahrenheit.setChecked(false);
                    toKelvin.setChecked(false);
                    toReaumur.setChecked(false);
                    toRankine.setChecked(false);
                    toCelsius.setChecked(false);
                    toDelisle.setChecked(false);
                    toRomer.setChecked(false);
                }
                if (button == toDelisle) {
                    toFahrenheit.setChecked(false);
                    toKelvin.setChecked(false);
                    toReaumur.setChecked(false);
                    toRankine.setChecked(false);
                    toNewton.setChecked(false);
                    toCelsius.setChecked(false);
                    toRomer.setChecked(false);
                }
                if (button == toRomer) {
                    toFahrenheit.setChecked(false);
                    toKelvin.setChecked(false);
                    toReaumur.setChecked(false);
                    toRankine.setChecked(false);
                    toNewton.setChecked(false);
                    toDelisle.setChecked(false);
                    toCelsius.setChecked(false);
                }

            }
            if (!text_toConvertValue.getText().toString().isEmpty()) {
                text_result.setText(String.valueOf(CalculateTemperature(text_toConvertValue.getText().toString())));
            } else {
                text_result.setText("");
            }
        }
    };

    public String CalculateTemperature(String _fromValueString) {
        double _result;
        double _fromValue;
        String _resultString = "";
        String _sufix;

        if(_fromValueString.equals(".")){
            _fromValue = 0.;
        }else{
            _fromValue = Double.parseDouble(_fromValueString);
        }

        //--------------FROM CELSIUS--------------//
        if (fromCelsius.isChecked()) {
            if (toCelsius.isChecked()) {
                _result = _fromValue;
                _sufix = getResources().getString(R.string.celsius_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toFahrenheit.isChecked()) {
                _result = TemperatureCalculator.celsiusFahrenheit(_fromValue);
                _sufix = getResources().getString(R.string.fahrenheit_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toKelvin.isChecked()) {
                _result = TemperatureCalculator.celsiusKelvin(_fromValue);
                _sufix = getResources().getString(R.string.kelvin_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toReaumur.isChecked()) {
                _result = TemperatureCalculator.celsiusReaumur(_fromValue);
                _sufix = getResources().getString(R.string.reaumur_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toRankine.isChecked()) {
                _result = TemperatureCalculator.celsiusRankine(_fromValue);
                _sufix = getResources().getString(R.string.rankine_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toNewton.isChecked()) {
                _result = TemperatureCalculator.celsiusNewton(_fromValue);
                _sufix = getResources().getString(R.string.newton_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toDelisle.isChecked()) {
                _result = TemperatureCalculator.celsiusDelisle(_fromValue);
                _sufix = getResources().getString(R.string.delisle_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toRomer.isChecked()) {
                _result = TemperatureCalculator.celsiusRomer(_fromValue);
                _sufix = getResources().getString(R.string.romer_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
        }

        //--------------FROM FAHRENHEIT--------------//
        if(fromFahrenheit.isChecked()){
            if(toFahrenheit.isChecked()){
                _result = _fromValue;
                _sufix = getResources().getString(R.string.fahrenheit_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toCelsius.isChecked()){
                _result = TemperatureCalculator.fahrenheitCelsius(_fromValue);
                _sufix = getResources().getString(R.string.celsius_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toKelvin.isChecked()){
                _result = TemperatureCalculator.fahrenheitKelvin(_fromValue);
                _sufix = getResources().getString(R.string.kelvin_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toReaumur.isChecked()){
                _result = TemperatureCalculator.fahrenheitReaumur(_fromValue);
                _sufix = getResources().getString(R.string.reaumur_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toRankine.isChecked()){
                _result = TemperatureCalculator.fahrenheitRankine(_fromValue);
                _sufix = getResources().getString(R.string.rankine_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toNewton.isChecked()){
                _result = TemperatureCalculator.fahrenheitNewton(_fromValue);
                _sufix = getResources().getString(R.string.newton_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toDelisle.isChecked()){
                _result = TemperatureCalculator.fahrenheitDelisle(_fromValue);
                _sufix = getResources().getString(R.string.delisle_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toRomer.isChecked()){
                _result = TemperatureCalculator.fahrenheitRomer(_fromValue);
                _sufix = getResources().getString(R.string.romer_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
        }

        //--------------FROM KELVIN--------------//
        if(fromKelvin.isChecked()){
            if(toKelvin.isChecked()){
                _result = _fromValue;
                _sufix = getResources().getString(R.string.kelvin_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toCelsius.isChecked()){
                _result = TemperatureCalculator.kelvinCelsius(_fromValue);
                _sufix = getResources().getString(R.string.celsius_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toFahrenheit.isChecked()){
                _result = TemperatureCalculator.kelvinFahrenheit(_fromValue);
                _sufix = getResources().getString(R.string.fahrenheit_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toReaumur.isChecked()){
                _result = TemperatureCalculator.kelvinReaumur(_fromValue);
                _sufix = getResources().getString(R.string.reaumur_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toRankine.isChecked()){
                _result = TemperatureCalculator.kelvinRankine(_fromValue);
                _sufix = getResources().getString(R.string.rankine_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toNewton.isChecked()){
                _result = TemperatureCalculator.kelvinNewton(_fromValue);
                _sufix = getResources().getString(R.string.newton_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toDelisle.isChecked()){
                _result = TemperatureCalculator.kelvinDelisle(_fromValue);
                _sufix = getResources().getString(R.string.delisle_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toRomer.isChecked()){
                _result = TemperatureCalculator.kelvinRomer(_fromValue);
                _sufix = getResources().getString(R.string.romer_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
        }

        //--------------FROM RÉAUMUR--------------//
        if(fromReaumur.isChecked()){
            if(toReaumur.isChecked()){
                _result = _fromValue;
                _sufix = getResources().getString(R.string.reaumur_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toCelsius.isChecked()){
                _result = TemperatureCalculator.reamurCelsius(_fromValue);
                _sufix = getResources().getString(R.string.celsius_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toKelvin.isChecked()){
                _result = TemperatureCalculator.reamurKelvin(_fromValue);
                _sufix = getResources().getString(R.string.kelvin_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toFahrenheit.isChecked()){
                _result = TemperatureCalculator.reamurFahrenheit(_fromValue);
                _sufix = getResources().getString(R.string.fahrenheit_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toRankine.isChecked()){
                _result = TemperatureCalculator.reamurRankine(_fromValue);
                _sufix = getResources().getString(R.string.rankine_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toNewton.isChecked()){
                _result = TemperatureCalculator.reamurNewton(_fromValue);
                _sufix = getResources().getString(R.string.newton_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toDelisle.isChecked()){
                _result = TemperatureCalculator.reamurDelisle(_fromValue);
                _sufix = getResources().getString(R.string.delisle_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if(toRomer.isChecked()){
                _result = TemperatureCalculator.reamurRomer(_fromValue);
                _sufix = getResources().getString(R.string.romer_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
        }

        //--------------FROM RANKINE--------------//
        if(fromRankine.isChecked()) {
            if (toRankine.isChecked()) {
                _result = _fromValue;
                _sufix = getResources().getString(R.string.rankine_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toFahrenheit.isChecked()) {
                _result = TemperatureCalculator.rankineFahrenheit(_fromValue);
                _sufix = getResources().getString(R.string.fahrenheit_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toKelvin.isChecked()) {
                _result = TemperatureCalculator.rankineKelvin(_fromValue);
                _sufix = getResources().getString(R.string.kelvin_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toReaumur.isChecked()) {
                _result = TemperatureCalculator.rankineReaumur(_fromValue);
                _sufix = getResources().getString(R.string.reaumur_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toCelsius.isChecked()) {
                _result = TemperatureCalculator.rankineCelsius(_fromValue);
                _sufix = getResources().getString(R.string.celsius_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toNewton.isChecked()) {
                _result = TemperatureCalculator.rankineNewton(_fromValue);
                _sufix = getResources().getString(R.string.newton_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toDelisle.isChecked()) {
                _result = TemperatureCalculator.rankineDelisle(_fromValue);
                _sufix = getResources().getString(R.string.delisle_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toRomer.isChecked()) {
                _result = TemperatureCalculator.rankineRomer(_fromValue);
                _sufix = getResources().getString(R.string.romer_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
        }

        //--------------FROM NEWTON--------------//
        if(fromNewton.isChecked()) {
            if (toNewton.isChecked()) {
                _result = _fromValue;
                _sufix = getResources().getString(R.string.newton_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toFahrenheit.isChecked()) {
                _result = TemperatureCalculator.newtonFahrenheit(_fromValue);
                _sufix = getResources().getString(R.string.fahrenheit_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toKelvin.isChecked()) {
                _result = TemperatureCalculator.newtonKelvin(_fromValue);
                _sufix = getResources().getString(R.string.kelvin_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toReaumur.isChecked()) {
                _result = TemperatureCalculator.newtonReaumur(_fromValue);
                _sufix = getResources().getString(R.string.reaumur_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toRankine.isChecked()) {
                _result = TemperatureCalculator.newtonRankine(_fromValue);
                _sufix = getResources().getString(R.string.rankine_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toCelsius.isChecked()) {
                _result = TemperatureCalculator.newtonCelsius(_fromValue);
                _sufix = getResources().getString(R.string.celsius_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toDelisle.isChecked()) {
                _result = TemperatureCalculator.newtonDelisle(_fromValue);
                _sufix = getResources().getString(R.string.delisle_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toRomer.isChecked()) {
                _result = TemperatureCalculator.newtonRomer(_fromValue);
                _sufix = getResources().getString(R.string.romer_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
        }

        //--------------FROM DELISLE--------------//
        if(fromDelisle.isChecked()) {
            if (toDelisle.isChecked()) {
                _result = _fromValue;
                _sufix = getResources().getString(R.string.delisle_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toFahrenheit.isChecked()) {
                _result = TemperatureCalculator.delisleFahrenheit(_fromValue);
                _sufix = getResources().getString(R.string.fahrenheit_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toKelvin.isChecked()) {
                _result = TemperatureCalculator.delisleKelvin(_fromValue);
                _sufix = getResources().getString(R.string.kelvin_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toReaumur.isChecked()) {
                _result = TemperatureCalculator.delisleReaumur(_fromValue);
                _sufix = getResources().getString(R.string.reaumur_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toRankine.isChecked()) {
                _result = TemperatureCalculator.delisleRankine(_fromValue);
                _sufix = getResources().getString(R.string.rankine_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toNewton.isChecked()) {
                _result = TemperatureCalculator.delisleNewton(_fromValue);
                _sufix = getResources().getString(R.string.newton_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toCelsius.isChecked()) {
                _result = TemperatureCalculator.delisleCelsius(_fromValue);
                _sufix = getResources().getString(R.string.celsius_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toRomer.isChecked()) {
                _result = TemperatureCalculator.delisleRomer(_fromValue);
                _sufix = getResources().getString(R.string.romer_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
        }

        //--------------FROM ROMER--------------//
        if(fromRomer.isChecked()) {
            if (toRomer.isChecked()) {
                _result = _fromValue;
                _sufix = getResources().getString(R.string.romer_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toFahrenheit.isChecked()) {
                _result = TemperatureCalculator.romerFahrenheit(_fromValue);
                _sufix = getResources().getString(R.string.fahrenheit_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toKelvin.isChecked()) {
                _result = TemperatureCalculator.romerKelvin(_fromValue);
                _sufix = getResources().getString(R.string.kelvin_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toReaumur.isChecked()) {
                _result = TemperatureCalculator.romerReaumur(_fromValue);
                _sufix = getResources().getString(R.string.reaumur_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toRankine.isChecked()) {
                _result = TemperatureCalculator.romerRankine(_fromValue);
                _sufix = getResources().getString(R.string.rankine_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toNewton.isChecked()) {
                _result = TemperatureCalculator.romerNewton(_fromValue);
                _sufix = getResources().getString(R.string.newton_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toDelisle.isChecked()) {
                _result = TemperatureCalculator.romerDelisle(_fromValue);
                _sufix = getResources().getString(R.string.delisle_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
            if (toCelsius.isChecked()) {
                _result = TemperatureCalculator.romerCelsius(_fromValue);
                _sufix = getResources().getString(R.string.celsius_sufix);
                _resultString = _result+" "+_sufix;
                return _resultString;
            }
        }
        return _resultString;
    }
}