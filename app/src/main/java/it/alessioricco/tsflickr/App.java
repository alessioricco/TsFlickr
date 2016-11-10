package it.alessioricco.tsflickr;

import android.app.Application;
import android.content.Context;

import java.util.Collections;
import java.util.List;

import dagger.ObjectGraph;
import it.alessioricco.tsflickr.injection.AppModule;
import it.alessioricco.tsflickr.injection.ObjectGraphSingleton;
import it.alessioricco.tsflickr.utils.StringUtils;
import st.lowlevel.storo.Storo;
import st.lowlevel.storo.StoroBuilder;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


/**
 * Created by alessioricco on 09/11/2016.
 */

public final class App extends Application {

//    //todo: this is a memory leak, must be fixed
    public static final String TAG = App.class.getSimpleName();
    private static Context mContext;
    private RequestQueue mRequestQueue;

    @Override public void onCreate() {
        super.onCreate();
        mContext = this;

        // Initialize ObjectGraph for dependency Injection
        if (ObjectGraphSingleton.getInstance() == null) {
            ObjectGraph objectGraph = ObjectGraph.create(getModules().toArray());
            ObjectGraphSingleton.setInstance(objectGraph);
            objectGraph.inject(this);
        }

//        // Load custom fonts
//        CalligraphyConfig.initDefault(
//                new CalligraphyConfig.Builder().setDefaultFontPath("fonts/Lato-Black.ttf")
//                        .setFontAttrId(R.attr.fontPath)
//                        .build());
//
//        // caching
//        if (!Storo.isInitialized()) {
//            StoroBuilder.configure(100 * 1024)  // maximum size to allocate in bytes
//                    .setDefaultCacheDirectory(this)
//                    .initialize();
//        }


    }

    //http://stackoverflow.com/questions/4391720/how-can-i-get-a-resource-content-from-a-static-context/4391811#4391811
    public static Context getContext(){
        return mContext;
    }

    private List<Object> getModules() {
        return Collections.<Object>singletonList(new AppModule(this));
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(StringUtils.isNullOrEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    @Override public void onTerminate() {
        super.onTerminate();
        ObjectGraphSingleton.reset();
    }

}

