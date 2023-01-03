/*
 * Click `Run` to execute the snippet below!
 */

import java.util.*;

import org.json.simple.*;

import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    String manifest_url = "https://us-central1-infinitus-interviews.cloudfunctions.net";
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }
        // create a client

        HttpClient client = HttpClient.newHttpClient();
        Solution s = new Solution();
        List<String> manifestIds = s.getManifest(client);
        for(String manifestId: manifestIds){
            System.out.println(manifestId);
        }
    }

    HttpRequest getHttpRequest(String url){
        return HttpRequest.newBuilder(URI.create(url)).header("accept", "application/json").build();

    }



    List<String> getManifest(HttpClient client){
        HttpRequest request = getHttpRequest(manifest_url+"/network-fetch-task/manifest");
        List<String> ids = new ArrayList<>();

        try{
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            Object obj=JSONValue.parse(response.body());
            JSONArray array=(JSONArray)obj;
            if(null!=array){
                for(int i=0;i<array.size();i++){
                    JSONObject manifests = (JSONObject)array.get(i);
                    if(manifests.get("type").equals("suggestion")){
                        ids.add(manifests.get("id").toString());
                    }
                }
            } else{
                System.out.println("response is null");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return ids;

    }
}

// Your previous Markdown content is preserved below:


// # Network Fetch
// Task Overview:

// We wish to process an input stream of data and be left with the items of interest. The result of this filtered set of data will be the input into our magical AI model, so getting it right is key to ensuring the success of our system.

// The input data stream is available via an unstable API (which we don't control), and we need your help to fetch it, filter it and then present the output neatly.


// ## Part 1

// The API hostname is 
// `https://us-central1-infinitus-interviews.cloudfunctions.net`. 

// You may retrieve a manifest from the path:
// `GET /network-fetch-task/manifest`

// It will return a JSON array of objects, e.g.:
// ```
// [
//   {
//     "type": "suggestion",
//     "id": "48A48B25-A079-4992-8290-6057FE0FBE93"
//   },
//   ...
// ]
// ```

// We only care about the ones of type "suggestion". Obtain the IDs of all the "suggestions".

// Armed with the IDs, next we wish to retrieve the actual suggestion data for each suggestion from the path:

// `GET /network-fetch-task/suggestion/:id`

// It will return a JSON object, e.g.:
// ```
// {
//   "type": "suggestion",
//   "id": "48A48B25-A079-4992-8290-6057FE0FBE93",
//   "category": "GOODBYES",
//   "title": "Nemo voluptas goodbyes",
//   "suggestion": "Excepturi nulla quod quia. Sunt non voluptas cum quia omnis dolor aut consequatur. Quos autem velit debitis ut possimus et dolorum et. goodbyes"
// }
// ```

// ## Part 2

// Now that you have retrieved the raw data, we need to assemble it neatly for presentation.

// We want to group the suggestions by category so it's easier to scan visually.

// We also want to sort the categories, and also the suggestions within each category alphabetically.

// Pretty print each category title as a heading, and then the sorted titles of each suggestion beneath.
// For example:

// ```
// GENERAL_CHATTER
//   - Qui dignissimos
//   - Qui exercitationem
//   ...
// MAIN_RESPONSES
//   - At nesciunt main_responses
//   - Id sint quia main_responses
//   ...
// ```

// # Language specific tips

// ### Javascript

// - Coderpad doesn't support fetch out of the box, but you can `const fetch = require("node-fetch");`

// ### Java

// - [Coderpad provides](https://coderpad.io/languages#java) the json-simple library for parsing the JSON responses
// - [JSON-simple javadoc link](http://alex-public-doc.s3.amazonaws.com/json_simple-1.1/index.html)
// - Some likely imports for the networking client:

// ```
// import java.io.*;
// import java.util.*;
// import java.net.http.*;
// import java.net.*;
// ```