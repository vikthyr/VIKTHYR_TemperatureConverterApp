package com.vikthyr.temperatureconverter;

public class TemperatureCalculator {

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------

    //CELSIUS TO CELSIUS
    public static double celsiusCelsius(double _num){
        double _result = _num;
        return _result;
    }
    //CELSIUS TO FAHRENHEIT
    public static double celsiusFahrenheit(double __num){
        double _result = (__num*1.8)+32;
        return _result;
    }
    //CELSIUS TO KELVIN
    public static double celsiusKelvin(double _num){
        double _result = _num + 273.15;
        return _result;
    }
    //CELSIUS TO RÉAUMUR
    public static double celsiusReaumur(double _num){
        double _result = _num * 4/5;
        return _result;
    }
    //CELSIUS TO RANKINE
    public static double celsiusRankine(double _num){
        double _result = _num * 4/5;
        _result = _result * 9/4 + 491.67;
        return _result;
    }
    //CELSIUS TO NEWTON
    public static double celsiusNewton(double _num){
        double _result = _num * 33/100;
        return _result;
    }
    //CELSIUS TO DELISLE
    public static double celsiusDelisle(double _num){
        double _result = _num * 1.5000 - 100.00;
        return _result;
    }
    //CELSIUS TO ROMER
    public static double celsiusRomer(double _num){
        double _result = _num * 0.52500 + 7.50;
        return _result;
    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------

    //FAHRENHEIT TO CELSIUS
    public static double fahrenheitCelsius(double _num){
        double _result = (_num-32)/1.8;
        return _result;
    }
    //FAHRENHEIT TO FAHRENHEIT
    public static double fahrenheitFahrenheit(double _num){
        double _result = _num;
        return _result;
    }

    //FAHRENHEIT TO KELVIN
    public static double fahrenheitKelvin(double _num){
        double _result = ((_num-273)*1.8)+32;
        return _result;
    }

    //FAHRENHEIT TO RÉAUMUR
    public static double fahrenheitReaumur(double _num){
        double _result = (_num - 32) * 4/9;
        return _result;
    }

    //FAHRENHEIT TO RANKINE
    public static double fahrenheitRankine(double _num){
        double _result = _num + 459.67;
        return _result;
    }

    //FAHRENHEIT TO NEWTON
    public static double fahrenheitNewton(double _num){
        double _result = (_num - 32)* 0.18333;
        return _result;
    }

    //FAHRENHEIT TO DELISLE
    public static double fahrenheitDelisle(double _num){
        double _result = (_num - 32)* 0.83333-100.00;
        return _result;
    }

    //FAHRENHEIT TO ROMER
    public static double fahrenheitRomer(double _num){
        double _result = (_num - 32)* 0.29167+ 7.50;
        return _result;
    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------

    //KELVIN TO CELSIUS
    public static double kelvinCelsius(double _num){
        double _result = _num - 273.15;
        return _result;
    }
    //KELVIN TO FAHRENHEIT
    public static double kelvinFahrenheit(double _num){
        double _result = (_num - 273.15) * 1.8000 + 32.00;
        return _result;
    }

    //KELVIN TO KELVIN
    public static double kelvinKelvin(double _num){
        double _result = _num;
        return _result;
    }

    //KELVIN TO RÉAUMUR
    public static double kelvinReaumur(double _num){
        double _result = (_num - 273.15)* 0.80000;
        return _result;
    }

    //KELVIN TO RANKINE
    public static double kelvinRankine(double _num){
        double _result = (_num - 273.15)* 1.8000+ 491.67;
        return _result;
    }

    //KELVIN TO NEWTON
    public static double kelvinNewton(double _num){
        double _result = (_num - 273.15)* 0.33000;
        return _result;
    }

    //KELVIN TO DELISLE
    public static double kelvinDelisle(double _num){
        double _result = (_num - 273.15)* 1.5000-100.00;
        return _result;
    }

    //KELVIN TO ROMER
    public static double kelvinRomer(double _num){
        double _result = (_num - 273.15)* 0.52500+ 7.50;
        return _result;
    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------

    //RÉAMUR TO CELSIUS
    public static double reamurCelsius(double _num){
        double _result = _num / 0.80000;
        return _result;
    }
    //RÉAMUR TO FAHRENHEIT
    public static double reamurFahrenheit(double _num){
        double _result = _num * 2.2500+ 32.00;
        return _result;
    }

    //RÉAMUR TO KELVIN
    public static double reamurKelvin(double _num){
        double _result = _num / 0.80000 + 273.15;
        return _result;
    }

    //RÉAMUR TO RÉAUMUR
    public static double reamurReaumur(double _num){
        double _result = _num;
        return _result;
    }

    //RÉAMUR TO RANKINE
    public static double reamurRankine(double _num){
        double _result = _num * 2.2500+ 491.67;
        return _result;
    }

    //RÉAMUR TO NEWTON
    public static double reamurNewton(double _num){
        double _result = _num * 0.41250;
        return _result;
    }

    //RÉAMUR TO DELISLE
    public static double reamurDelisle(double _num){
        double _result = _num * 1.8750-100.00;
        return _result;
    }

    //RÉAMUR TO ROMER
    public static double reamurRomer(double _num){
        double _result = _num * 0.65625+ 7.50;
        return _result;
    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------

    //RANKINE TO CELSIUS
    public static double rankineCelsius(double _num){
        double _result = (_num - 491.67) / 1.8000;
        return _result;
    }
    //RANKINE TO FAHRENHEIT
    public static double rankineFahrenheit(double _num){
        double _result = (_num - 491.67)+ 32.00;
        return _result;
    }

    //RANKINE TO KELVIN
    public static double rankineKelvin(double _num){
        double _result = ((_num - 491.67) / 1.8000) + 273.15;
        return _result;
    }

    //RANKINE TO RÉAUMUR
    public static double rankineReaumur(double _num){
        double _result = (_num - 491.67)* 0.44444;
        return _result;
    }

    //RANKINE TO RANKINE
    public static double rankineRankine(double _num){
        double _result = _num;
        return _result;
    }

    //RANKINE TO NEWTON
    public static double rankineNewton(double _num){
        double _result = (_num - 491.67)* 0.18333;
        return _result;
    }

    //RANKINE TO DELISLE
    public static double rankineDelisle(double _num){
        double _result = (_num - 491.67)* 0.83333-100.00;
        return _result;
    }

    //RANKINE TO ROMER
    public static double rankineRomer(double _num){
        double _result = (_num - 491.67)* 0.29167+ 7.50;
        return _result;
    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------

    //NEWTON TO CELSIUS
    public static double newtonCelsius(double _num){
        double _result = _num / 0.33000;
        return _result;
    }
    //NEWTON TO FAHRENHEIT
    public static double newtonFahrenheit(double _num){
        double _result = _num * 5.4545+ 32.00;
        return _result;
    }

    //NEWTON TO KELVIN
    public static double newtonKelvin(double _num){
        double _result = (_num / 0.33000) + 273.15;
        return _result;
    }

    //NEWTON TO RÉAUMUR
    public static double newtonReaumur(double _num){
        double _result = _num * 2.4242;
        return _result;
    }

    //NEWTON TO RANKINE
    public static double newtonRankine(double _num){
        double _result = _num * 5.4545+ 491.67;
        return _result;
    }

    //NEWTON TO NEWTON
    public static double newtonNewton(double _num){
        double _result = _num;
        return _result;
    }

    //NEWTON TO DELISLE
    public static double newtonDelisle(double _num){
        double _result = _num * 4.5455-100.00;
        return _result;
    }

    //NEWTON TO ROMER
    public static double newtonRomer(double _num){
        double _result = _num * 1.5909+ 7.50;
        return _result;
    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------

    //DELISLE TO CELSIUS
    public static double delisleCelsius(double _num){
        double _result = (_num + 100) /1.5000 ;
        return _result;
    }
    //DELISLE TO FAHRENHEIT
    public static double delisleFahrenheit(double _num){
        double _result = (_num + 100)* 1.2000+ 32.00;
        return _result;
    }

    //DELISLE TO KELVIN
    public static double delisleKelvin(double _num){
        double _result = ((_num + 100) / 1.5000) + 273.15;
        return _result;
    }

    //DELISLE TO RÉAUMUR
    public static double delisleReaumur(double _num){
        double _result = (_num + 100)* 0.53333;
        return _result;
    }

    //DELISLE TO RANKINE
    public static double delisleRankine(double _num){
        double _result = (_num + 100)* 1.2000+ 491.67;
        return _result;
    }

    //DELISLE TO NEWTON
    public static double delisleNewton(double _num){
        double _result = (_num + 100)* 0.22000;
        return _result;
    }

    //DELISLE TO DELISLE
    public static double delisleDelisle(double _num){
        double _result = _num;
        return _result;
    }

    //DELISLE TO ROMER
    public static double delisleRomer(double _num){
        double _result = (_num + 100)* 0.35000+ 7.50;
        return _result;
    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------

    //ROMER TO CELSIUS
    public static double romerCelsius(double _num){
        double _result = (_num - 7.5) / 0.52500 ;
        return _result;
    }
    //ROMER TO FAHRENHEIT
    public static double romerFahrenheit(double _num){
        double _result = (_num - 7.5)* 3.4286+ 32.00;
        return _result;
    }

    //ROMER TO KELVIN
    public static double romerKelvin(double _num){
        double _result = ((_num - 7.5) / 0.52500) + 273.15;
        return _result;
    }

    //ROMER TO RÉAUMUR
    public static double romerReaumur(double _num){
        double _result = (_num - 7.5)* 1.5238;
        return _result;
    }

    //ROMER TO RANKINE
    public static double romerRankine(double _num){
        double _result = (_num - 7.5)* 3.4286+ 491.67;
        return _result;
    }

    //ROMER TO NEWTON
    public static double romerNewton(double _num){
        double _result = (_num - 7.5)* 0.62857;
        return _result;
    }

    //ROMER TO DELISLE
    public static double romerDelisle(double _num){
        double _result = (_num - 7.5)* 2.8571-100.00;
        return _result;
    }

    //ROMER TO ROMER
    public static double romerRomer(double _num){
        double _result = _num;
        return _result;
    }

    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------
    //--------------------------------------------------------------------------

    public static String getFormula(String fromScale, String toScale){
        String formula = "";
        switch (fromScale){
            case "Celsius":
                switch (toScale){
                    case "Celsius":
                        formula = "°C = °C";
                        break;

                    case "Fahrenheit":
                        formula = "°F = (°C * 1.8) + 32";
                        break;

                    case "Kelvin":
                        formula = "K = °C + 273.15";
                        break;

                    case "Réaumur":
                        formula = "°Ré = °C * 4 / 5";
                        break;

                    case "Rankine":
                        formula = "°Ra = (°C * 4/5) * (9/4) + 491.67";
                        break;

                    case "Newton":
                        formula = "°N = °C * 33 / 100";
                        break;

                    case "Delisle":
                        formula = "°De = °C * 1.5 - 100";
                        break;

                    case "Rømer":
                        formula = "°Rø = °C * 0.525 + 7.5";
                        break;
                }
                return formula;

            case "Fahrenheit":
                switch (toScale){
                    case "Celsius":
                        formula = "°C = (°F - 32) / 1.8";
                        break;

                    case "Fahrenheit":
                        formula = "°F = °F";
                        break;

                    case "Kelvin":
                        formula = "K = ((°F - 273) * 1.8) + 32";
                        break;

                    case "Réaumur":
                        formula = "°Ré = (°F - 32) * 4 / 9";
                        break;

                    case "Rankine":
                        formula = "°Ra = °F + 459.67";
                        break;

                    case "Newton":
                        formula = "°N = (°F - 32) * 0.18333";
                        break;

                    case "Delisle":
                        formula = "°De = (°F - 32) * 0.8333 - 100";
                        break;

                    case "Rømer":
                        formula = "°Rø = (°F - 32) * 0.29167 + 7.5";
                        break;
                }
                return formula;

            case "Kelvin":
                switch (toScale){
                    case "Celsius":
                        formula = "°C = K - 273.15";
                        break;

                    case "Fahrenheit":
                        formula = "°F = (K - 273.15) * 1.8 + 32";
                        break;

                    case "Kelvin":
                        formula = "K = K";
                        break;

                    case "Réaumur":
                        formula = "°Ré = (K - 273.15) * 0.8";
                        break;

                    case "Rankine":
                        formula = "°Ra = (K - 273.15) * 1.8 + 491.67";
                        break;

                    case "Newton":
                        formula = "°N = (K - 273.15) * 0.33";
                        break;

                    case "Delisle":
                        formula = "°De = (K - 273.15) * 1.5 - 100";
                        break;

                    case "Rømer":
                        formula = "°Rø = (K - 273.15) * 0.525 + 7.5";
                        break;
                }
                return formula;

            case "Réaumur":
                switch (toScale){
                    case "Celsius":
                        formula = "°C = °Ré / 0.8";
                        break;

                    case "Fahrenheit":
                        formula = "°F = °Ré * 2.25 + 32";
                        break;

                    case "Kelvin":
                        formula = "K = °Ré / 0.8 + 273.15";
                        break;

                    case "Réaumur":
                        formula = "°Ré = °Ré";
                        break;

                    case "Rankine":
                        formula = "°Ra = °Ré * 2.25 + 491.67";
                        break;

                    case "Newton":
                        formula = "N = °Ré * 0.4125";
                        break;

                    case "Delisle":
                        formula = "°De = °Ré * 1.875 - 100";
                        break;

                    case "Rømer":
                        formula = "°Rø = °Ré * 0.65625 + 7.5";
                        break;
                }
                return formula;

            case "Rankine":
                switch (toScale){
                    case "Celsius":
                        formula = "°C = (°Ra - 491.67) / 1.8";
                        break;

                    case "Fahrenheit":
                        formula = "°F = (°Ra - 491.67) + 32";
                        break;

                    case "Kelvin":
                        formula = "K = ((°Ra - 491.67) / 1.8) + 273.15";
                        break;

                    case "Réaumur":
                        formula = "°Ré = (°Ra - 491.67) * 0.44444";
                        break;

                    case "Rankine":
                        formula = "°Ra = °Ra";
                        break;

                    case "Newton":
                        formula = "N = (°Ra - 491.67) * 0.18333";
                        break;

                    case "Delisle":
                        formula = "°De = (°Ra - 491.67) * 0.83333 - 100";
                        break;

                    case "Rømer":
                        formula = "°Rø = (°Ra - 491.67) * 0.29167 + 7.5";
                        break;
                }
                return formula;

            case "Newton":
                switch (toScale){
                    case "Celsius":
                        formula = "°C = °N / 0.33";
                        break;

                    case "Fahrenheit":
                        formula = "°F = °N * 5.4545 + 32";
                        break;

                    case "Kelvin":
                        formula = "K = (°N / 0.33) + 273.15";
                        break;

                    case "Réaumur":
                        formula = "°Ré = °N * 2.4242";
                        break;

                    case "Rankine":
                        formula = "°Ra = °N * 5.4545 + 491.67";
                        break;

                    case "Newton":
                        formula = "°N = °N";
                        break;

                    case "Delisle":
                        formula = "°De = °N * 4.5455 - 100";
                        break;

                    case "Rømer":
                        formula = "°Rø = °N * 1.5909 + 7.5";
                        break;
                }
                return formula;

            case "Delisle":
                switch (toScale){
                    case "Celsius":
                        formula = "°C = (°De + 100) / 1.5";
                        break;

                    case "Fahrenheit":
                        formula = "°F = (°De + 100) * 1.2 + 32";
                        break;

                    case "Kelvin":
                        formula = "K = ((°De + 100) / 1.5) + 273.15";
                        break;

                    case "Réaumur":
                        formula = "°Ré = (°De + 100) * 0.53333";
                        break;

                    case "Rankine":
                        formula = "°Ra = (°De + 100) * 1.2 + 491.67";
                        break;

                    case "Newton":
                        formula = "°N = (°De + 100) * 0.22";
                        break;

                    case "Delisle":
                        formula = "°De = °De";
                        break;

                    case "Rømer":
                        formula = "°Rø = (°De + 100) * 0.35 + 7.5";
                        break;
                }
                return formula;

            case "Rømer":
                switch (toScale){
                    case "Celsius":
                        formula = "°C = (°Rø - 7.5) / 0.525";
                        break;

                    case "Fahrenheit":
                        formula = "°F = (°Rø - 7.5) * 3.4286 + 32";
                        break;

                    case "Kelvin":
                        formula = "K = ((°Rø - 7.5) / 0.525) + 273.15";
                        break;

                    case "Réaumur":
                        formula = "°Ré = (°Rø - 7.5) * 1.5238";
                        break;

                    case "Rankine":
                        formula = "°Ra = (°Rø - 7.5) * 3.4286 + 491.67";
                        break;

                    case "Newton":
                        formula = "°N = (°Rø - 7.5) * 0.62857";
                        break;

                    case "Delisle":
                        formula = "°De = (°Rø - 7.5) * 2.8571 - 100";
                        break;

                    case "Rømer":
                        formula = "°Rø = °Rø";
                        break;
                }
                return formula;
        }
        return formula;
    }
}
