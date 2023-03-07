package org.ace.insurance.fireservice.component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.ace.insurance.productservice.dto.MC001;
import org.ace.insurance.productservice.dto.NT001;
import org.ace.insurance.productservice.dto.SC001;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Component
public class ResponseManager {
    Gson gson = new GsonBuilder().create();

    public String getResponseString(Object object) {
        String responseString = gson.toJson(object);
        return responseString;
    }

    public String makingJSonString(List<MC001> mainCategryWSList, String realPath) throws UnsupportedEncodingException {
        JSONArray mainWSDTO_array = new JSONArray();
        String mainWS_String = "";
        for (MC001 mainWS : mainCategryWSList) {
            JSONObject mainCateObj = new JSONObject();
            JSONArray name_Array = new JSONArray();
            // JSONArray photo_Array = new JSONArray();
            JSONArray subcategory_Array = new JSONArray();
            // POI001 photoWSDTO = new POI001();
            try {
                mainCateObj.put("id", mainWS.getId());
                mainCateObj.put("productId", mainWS.getProductId());
                mainCateObj.put("order", mainWS.getOrder());
                mainCateObj.put("version", mainWS.getVersion());
                for (NT001 name : mainWS.getTextList()) {
                    JSONObject nameObj = new JSONObject();
                    nameObj.put("id", name.getId());
                    nameObj.put("name", URLEncoder.encode(name.getName(), "UTF-8"));
                    nameObj.put("content", URLEncoder.encode(name.getContent(), "UTF-8"));
                    nameObj.put("language", name.getLanguage());
                    nameObj.put("version", name.getVersion());
                    name_Array.put(nameObj);
                }
                mainCateObj.put("textList", name_Array);

                for (SC001 sub : mainWS.getSubCategoryList()) {
                    subcategory_Array.put(makingJSonStringSubCategory(sub, realPath));
                    mainCateObj.put("subCategoryList", subcategory_Array);
                }
            } catch (Exception ex) {
                ex.getLocalizedMessage();
            }
            mainWSDTO_array.put(mainCateObj);
        }
        mainWS_String = mainWSDTO_array.toString();
        return mainWS_String;
    }

    public JSONObject makingJSonStringSubCategory(SC001 sub, String realPath) throws UnsupportedEncodingException {
        JSONArray name_Array = new JSONArray();
        // JSONArray photo_Array = new JSONArray();
        JSONObject subObj = new JSONObject();
        if (sub != null) {
            try {
                subObj.put("id", sub.getId());
                subObj.put("order", sub.getOrder());
                subObj.put("version", sub.getVersion());

                for (NT001 name : sub.getTextList()) {
                    JSONObject nameObj = new JSONObject();
                    nameObj.put("id", name.getId());
                    nameObj.put("name", URLEncoder.encode(name.getName(), "UTF-8"));
                    nameObj.put("content", URLEncoder.encode(name.getContent(), "UTF-8"));
                    nameObj.put("language", name.getLanguage());
                    nameObj.put("version", name.getVersion());
                    name_Array.put(nameObj);
                }
                subObj.put("textList", name_Array);
            } catch (Exception ex) {
                ex.getLocalizedMessage();
            }
        }
        return subObj;
    }
}
