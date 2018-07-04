package utils;

import org.json.JSONArray;

public class Utility {

    public static void handleProvinceResponse(String response) {
        try {
            JSONArray provinces = new JSONArray(response);

        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    public static void handleCityResponse(String response) {

    }
}
