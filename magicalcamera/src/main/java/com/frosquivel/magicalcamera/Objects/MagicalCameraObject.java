package com.frosquivel.magicalcamera.Objects;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.graphics.Bitmap;

import com.frosquivel.magicalcamera.Functionallities.ActionPicture;
import com.frosquivel.magicalcamera.Functionallities.FaceRecognition;
import com.frosquivel.magicalcamera.Functionallities.PermissionGranted;
import com.frosquivel.magicalcamera.Functionallities.PrivateInformation;
import com.frosquivel.magicalcamera.Functionallities.SaveEasyPhoto;
import com.frosquivel.magicalcamera.Functionallities.URIPaths;

/**
 * Created by Fabian on 07/12/2016.
 */

public class MagicalCameraObject {
    //================================================================================
    // Properties
    //================================================================================
    //region Properties
    //The constants for take or selected photo validate
    public static final int TAKE_PHOTO = 0;
    public static final int SELECT_PHOTO = 1;
    public static final int LANDSCAPE_CAMERA = 2;
    public static final int NORMAL_CAMERA = 3;

    //compress format public static variables
    public static final Bitmap.CompressFormat JPEG = Bitmap.CompressFormat.JPEG;
    public static final Bitmap.CompressFormat PNG = Bitmap.CompressFormat.PNG;
    public static final Bitmap.CompressFormat WEBP = Bitmap.CompressFormat.WEBP;



    //my activity variable
    private Activity activity;

    //the face recognition class for instance
    private FaceRecognition faceRecognition;

    //the private information class for instance
    private PrivateInformation privateInformation;

    //the private variable of saveEasyPhoto
    private SaveEasyPhoto saveEasyPhoto;

    //the actions to take pictures or selected
    private ActionPicture actionPicture;

    //validate the permission granted for android 6.0 or more
    private PermissionGranted permissionGranted;

    //the uri of paths class
    private URIPaths uriPaths;
    //endregion


    //Constructor
    public MagicalCameraObject(Activity activity){
        this.activity = activity;
        this.faceRecognition = new FaceRecognition();
        this.privateInformation = new PrivateInformation();
        this.uriPaths = new URIPaths(this.privateInformation);
        this.saveEasyPhoto = new SaveEasyPhoto();
        this.permissionGranted = new PermissionGranted(activity);
        this.actionPicture = new ActionPicture(activity, ActionPictureObject.BEST_QUALITY_PHOTO, this.permissionGranted, this.uriPaths);
    }

    public MagicalCameraObject(Activity activity, int qualityPhoto){
        this.activity = activity;
        this.faceRecognition = new FaceRecognition();
        this.privateInformation = new PrivateInformation();
        this.saveEasyPhoto = new SaveEasyPhoto();
        this.permissionGranted = new PermissionGranted(activity);
        this.actionPicture = new ActionPicture(activity, qualityPhoto, this.permissionGranted, this.uriPaths);
    }


    //================================================================================
    // Accessors
    //================================================================================

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public FaceRecognition getFaceRecognition() {
        return faceRecognition;
    }

    public void setFaceRecognition(FaceRecognition faceRecognition) {
        this.faceRecognition = faceRecognition;
    }

    public PrivateInformation getPrivateInformation() {
        return privateInformation;
    }

    public void setPrivateInformation(PrivateInformation privateInformation) {
        this.privateInformation = privateInformation;
    }

    public SaveEasyPhoto getSaveEasyPhoto() {
        return saveEasyPhoto;
    }

    public void setSaveEasyPhoto(SaveEasyPhoto saveEasyPhoto) {
        this.saveEasyPhoto = saveEasyPhoto;
    }

    public ActionPicture getActionPicture() {
        return actionPicture;
    }

    public void setActionPicture(ActionPicture actionPicture) {
        this.actionPicture = actionPicture;
    }

    public PermissionGranted getPermissionGranted() {
        return permissionGranted;
    }

    public void setPermissionGranted(PermissionGranted permissionGranted) {
        this.permissionGranted = permissionGranted;
    }

    public URIPaths getUriPaths() {
        return uriPaths;
    }
    //endregion
}