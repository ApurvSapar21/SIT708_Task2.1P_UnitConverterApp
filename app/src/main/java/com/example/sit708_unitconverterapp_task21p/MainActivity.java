package com.example.sit708_unitconverterapp_task21p;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner sourceUnitSpinner, destUnitSpinner;
    private EditText valueEditText;
    private Button convertButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sourceUnitSpinner = findViewById(R.id.sourceUnitSpinner);
        destUnitSpinner = findViewById(R.id.destUnitSpinner);
        valueEditText = findViewById(R.id.valueEditText);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertUnits();
            }
        });
    }

    private void convertUnits() {
        String sourceUnit = sourceUnitSpinner.getSelectedItem().toString();
        String destUnit = destUnitSpinner.getSelectedItem().toString();
        String inputValue = valueEditText.getText().toString();

        // Check if input value is empty
        if (inputValue.isEmpty()) {
            resultTextView.setText("Please enter a value.");
            return;
        }

        double value;
        try {
            value = Double.parseDouble(inputValue);
        } catch (NumberFormatException e) {
            resultTextView.setText("Invalid input. Please enter a valid number.");
            return;
        }

        double result = 0;

        if (sourceUnit.equals(destUnit)) {
            result = value;
        } else if (sourceUnit.equals("Inches")) {
            if (destUnit.equals("Centimeters")) {
                result = value * 2.54;
            } else if (destUnit.equals("Feet")) {
                result = value / 12;
            } else if (destUnit.equals("Yards")) {
                result = value / 36;
            } else if (destUnit.equals("Miles")) {
                result = value / 63360;
            }
        } else if (sourceUnit.equals("Feet")) {
            if (destUnit.equals("Inches")) {
                result = value * 12;
            } else if (destUnit.equals("Centimeters")) {
                result = value * 30.48;
            } // Add more conversion logic for other destination units
        } else if (sourceUnit.equals("Yards")) {
            if (destUnit.equals("Inches")) {
                result = value * 36;
            } else if (destUnit.equals("Feet")) {
                result = value * 3;
            } // Add more conversion logic for other destination units
        } else if (sourceUnit.equals("Miles")) {
            if (destUnit.equals("Inches")) {
                result = value * 63360;
            } else if (destUnit.equals("Feet")) {
                result = value * 5280;
            } // Add more conversion logic for other destination units
        } else if (sourceUnit.equals("Pounds")) {
            if (destUnit.equals("Kilograms")) {
                result = value * 0.453592;
            } else if (destUnit.equals("Ounces")) {
                result = value * 16;
            } // Add more conversion logic for other destination units
        } else if (sourceUnit.equals("Ounces")) {
            if (destUnit.equals("Pounds")) {
                result = value / 16;
            } else if (destUnit.equals("Grams")) {
                result = value * 28.3495;
            } // Add more conversion logic for other destination units
        } else if (sourceUnit.equals("Tons")) {
            if (destUnit.equals("Kilograms")) {
                result = value * 907.185;
            } // Add more conversion logic for other destination units
        } else if (sourceUnit.equals("Celsius")) {
            if (destUnit.equals("Fahrenheit")) {
                result = (value * 1.8) + 32;
            } else if (destUnit.equals("Kelvin")) {
                result = value + 273.15;
            }
        } else if (sourceUnit.equals("Fahrenheit")) {
            if (destUnit.equals("Celsius")) {
                result = (value - 32) / 1.8;
            } else if (destUnit.equals("Kelvin")) {
                result = (value - 32) / 1.8 + 273.15;
            }
        } else if (sourceUnit.equals("Kelvin")) {
            if (destUnit.equals("Celsius")) {
                result = value - 273.15;
            } else if (destUnit.equals("Fahrenheit")) {
                result = (value - 273.15) * 1.8 + 32;
            }
        }

        resultTextView.setText(String.valueOf(result));
    }


}
