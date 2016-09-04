package xj.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class XjClientHttp {

    protected String restUrl;
    protected String requestMethod;
    protected String[] params;
    protected String[] paramsValue;
    private String[] headers;
    private String[] headersValue;
    protected static int CONNECTION_TIMEOUT = 30000;
    protected static int DATARETRIEVAL_TIMEOUT = 30000;
    protected static final String CHAR_SET = "UTF-8";

    public XjClientHttp() {
        this.requestMethod = "POST";
    }
    
    // getter and setter
    public XjClientHttp setRestUrl(String restUrl) {
        this.restUrl = restUrl;
        return this;
    }

    public XjClientHttp setParams(String[] params) {
        this.params = params;
        return this;
    }

    public XjClientHttp setParamsValue(String[] paramsValue) {
        this.paramsValue = paramsValue;
        return this;
    }

    public XjClientHttp setHeaders(String[] headers) {
        this.headers = headers;
        return this;
    }

    public XjClientHttp setHeadersValue(String[] headersValue) {
        this.headersValue = headersValue;
        return this;
    }

    public String send() {
        HttpURLConnection urlConnection = null;
        String result = null;

        try {
            // create connection
            urlConnection = (HttpURLConnection) new URL(restUrl).openConnection();
            urlConnection.setDoOutput(true); // This means POST method to be used
            urlConnection.setRequestProperty("Accept-Charset", CHAR_SET); //For servers to know what encoding is used for the parameters
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + CHAR_SET);
            urlConnection.setConnectTimeout(CONNECTION_TIMEOUT);
            urlConnection.setReadTimeout(DATARETRIEVAL_TIMEOUT);
            urlConnection.setRequestMethod(requestMethod);

            // add header
            if (headers != null) {
                for (int n = 0; n < headers.length; n++) {
                    if (headersValue[n] != null) {
                        urlConnection.setRequestProperty(headers[n], headersValue[n]);
                    }
                }
            }

            // add parameter
            String data = "";
            if (params != null) {
                boolean first = true;
                for (int i = 0; i < params.length; i++) {
                    if (!first) {
                        data += "&";
                    }
                    if (paramsValue[i] != null) {
                        data += URLEncoder.encode(params[i], CHAR_SET) + "=" + URLEncoder.encode(paramsValue[i], CHAR_SET);
                        first = false;
                    }
                }

                urlConnection.setFixedLengthStreamingMode(data.getBytes().length);
            }

            PrintWriter output = new PrintWriter(urlConnection.getOutputStream());
            output.print(data); //Post data
            output.close();

            //urlConnection.connect();
            InputStream responseStream = urlConnection.getInputStream();
            /*getInputStream*/       // handle issues
            int statusCode = urlConnection.getResponseCode();
            if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                // handle unauthorized (if service requires user login)
            } else if (statusCode != HttpURLConnection.HTTP_OK) {
                // handle any other errors, like 404, 500,..
            }

            // create JSON object from content
            BufferedReader rd = new BufferedReader(new InputStreamReader(responseStream, CHAR_SET)); // 
            String response = "";
            String line;
            while ((line = rd.readLine()) != null) {
                response += line;
            }
            result = response;

        } catch (MalformedURLException | SocketTimeoutException e) {
            System.err.println(e.getMessage());
        } // data retrieval or connection timed out
        catch (IOException e) {
            System.err.println(e.getMessage());

            // could not read response body 
            // (could not create input stream)
        } // response body is no valid JSON string
        finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return result;
    }
}
