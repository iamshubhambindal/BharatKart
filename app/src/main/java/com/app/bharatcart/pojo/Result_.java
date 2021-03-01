
package com.app.bharatcart.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result_ implements Parcelable {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("descriptionHTML")
    @Expose
    private String descriptionHTML;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("installs")
    @Expose
    private String installs;
    @SerializedName("minInstalls")
    @Expose
    private Integer minInstalls;
    @SerializedName("maxInstalls")
    @Expose
    private Integer maxInstalls;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("scoreText")
    @Expose
    private String scoreText;
    @SerializedName("ratings")
    @Expose
    private Integer ratings;
    @SerializedName("reviews")
    @Expose
    private Integer reviews;
    @SerializedName("histogram")
    @Expose
    private Histogram histogram;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("free")
    @Expose
    private Boolean free;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("priceText")
    @Expose
    private String priceText;
    @SerializedName("offersIAP")
    @Expose
    private Boolean offersIAP;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("androidVersion")
    @Expose
    private String androidVersion;
    @SerializedName("androidVersionText")
    @Expose
    private String androidVersionText;
    @SerializedName("developer")
    @Expose
    private String developer;
    @SerializedName("developerId")
    @Expose
    private String developerId;
    @SerializedName("developerEmail")
    @Expose
    private String developerEmail;
    @SerializedName("developerWebsite")
    @Expose
    private String developerWebsite;
    @SerializedName("developerAddress")
    @Expose
    private String developerAddress;
    @SerializedName("privacyPolicy")
    @Expose
    private String privacyPolicy;
    @SerializedName("developerInternalID")
    @Expose
    private String developerInternalID;
    @SerializedName("genre")
    @Expose
    private String genre;
    @SerializedName("genreId")
    @Expose
    private String genreId;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("headerImage")
    @Expose
    private String headerImage;
    @SerializedName("screenshots")
    @Expose
    private List<String> screenshots = null;
    @SerializedName("contentRating")
    @Expose
    private String contentRating;
    @SerializedName("adSupported")
    @Expose
    private Boolean adSupported;
    @SerializedName("released")
    @Expose
    private String released;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("recentChanges")
    @Expose
    private String recentChanges;
    @SerializedName("comments")
    @Expose
    private List<String> comments = null;
    @SerializedName("editorsChoice")
    @Expose
    private Boolean editorsChoice;
    @SerializedName("appId")
    @Expose
    private String appId;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("IAPRange")
    @Expose
    private String iAPRange;
    @SerializedName("video")
    @Expose
    private String video;
    @SerializedName("videoImage")
    @Expose
    private String videoImage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionHTML() {
        return descriptionHTML;
    }

    public void setDescriptionHTML(String descriptionHTML) {
        this.descriptionHTML = descriptionHTML;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getInstalls() {
        return installs;
    }

    public void setInstalls(String installs) {
        this.installs = installs;
    }

    public Integer getMinInstalls() {
        return minInstalls;
    }

    public void setMinInstalls(Integer minInstalls) {
        this.minInstalls = minInstalls;
    }

    public Integer getMaxInstalls() {
        return maxInstalls;
    }

    public void setMaxInstalls(Integer maxInstalls) {
        this.maxInstalls = maxInstalls;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getScoreText() {
        return scoreText;
    }

    public void setScoreText(String scoreText) {
        this.scoreText = scoreText;
    }

    public Integer getRatings() {
        return ratings;
    }

    public void setRatings(Integer ratings) {
        this.ratings = ratings;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

    public Histogram getHistogram() {
        return histogram;
    }

    public void setHistogram(Histogram histogram) {
        this.histogram = histogram;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPriceText() {
        return priceText;
    }

    public void setPriceText(String priceText) {
        this.priceText = priceText;
    }

    public Boolean getOffersIAP() {
        return offersIAP;
    }

    public void setOffersIAP(Boolean offersIAP) {
        this.offersIAP = offersIAP;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    public String getAndroidVersionText() {
        return androidVersionText;
    }

    public void setAndroidVersionText(String androidVersionText) {
        this.androidVersionText = androidVersionText;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    public String getDeveloperEmail() {
        return developerEmail;
    }

    public void setDeveloperEmail(String developerEmail) {
        this.developerEmail = developerEmail;
    }

    public String getDeveloperWebsite() {
        return developerWebsite;
    }

    public void setDeveloperWebsite(String developerWebsite) {
        this.developerWebsite = developerWebsite;
    }

    public String getDeveloperAddress() {
        return developerAddress;
    }

    public void setDeveloperAddress(String developerAddress) {
        this.developerAddress = developerAddress;
    }

    public String getPrivacyPolicy() {
        return privacyPolicy;
    }

    public void setPrivacyPolicy(String privacyPolicy) {
        this.privacyPolicy = privacyPolicy;
    }

    public String getDeveloperInternalID() {
        return developerInternalID;
    }

    public void setDeveloperInternalID(String developerInternalID) {
        this.developerInternalID = developerInternalID;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    public List<String> getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(List<String> screenshots) {
        this.screenshots = screenshots;
    }

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    public Boolean getAdSupported() {
        return adSupported;
    }

    public void setAdSupported(Boolean adSupported) {
        this.adSupported = adSupported;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRecentChanges() {
        return recentChanges;
    }

    public void setRecentChanges(String recentChanges) {
        this.recentChanges = recentChanges;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public Boolean getEditorsChoice() {
        return editorsChoice;
    }

    public void setEditorsChoice(Boolean editorsChoice) {
        this.editorsChoice = editorsChoice;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIAPRange() {
        return iAPRange;
    }

    public void setIAPRange(String iAPRange) {
        this.iAPRange = iAPRange;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(String videoImage) {
        this.videoImage = videoImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.descriptionHTML);
        dest.writeString(this.summary);
        dest.writeString(this.installs);
        dest.writeValue(this.minInstalls);
        dest.writeValue(this.maxInstalls);
        dest.writeValue(this.score);
        dest.writeString(this.scoreText);
        dest.writeValue(this.ratings);
        dest.writeValue(this.reviews);
        dest.writeParcelable(this.histogram, flags);
        dest.writeValue(this.price);
        dest.writeValue(this.free);
        dest.writeString(this.currency);
        dest.writeString(this.priceText);
        dest.writeValue(this.offersIAP);
        dest.writeString(this.size);
        dest.writeString(this.androidVersion);
        dest.writeString(this.androidVersionText);
        dest.writeString(this.developer);
        dest.writeString(this.developerId);
        dest.writeString(this.developerEmail);
        dest.writeString(this.developerWebsite);
        dest.writeString(this.developerAddress);
        dest.writeString(this.privacyPolicy);
        dest.writeString(this.developerInternalID);
        dest.writeString(this.genre);
        dest.writeString(this.genreId);
        dest.writeString(this.icon);
        dest.writeString(this.headerImage);
        dest.writeStringList(this.screenshots);
        dest.writeString(this.contentRating);
        dest.writeValue(this.adSupported);
        dest.writeString(this.released);
        dest.writeString(this.updated);
        dest.writeString(this.version);
        dest.writeString(this.recentChanges);
        dest.writeStringList(this.comments);
        dest.writeValue(this.editorsChoice);
        dest.writeString(this.appId);
        dest.writeString(this.url);
        dest.writeString(this.iAPRange);
        dest.writeString(this.video);
        dest.writeString(this.videoImage);
    }

    public Result_() {
    }

    protected Result_(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.descriptionHTML = in.readString();
        this.summary = in.readString();
        this.installs = in.readString();
        this.minInstalls = (Integer) in.readValue(Integer.class.getClassLoader());
        this.maxInstalls = (Integer) in.readValue(Integer.class.getClassLoader());
        this.score = (Double) in.readValue(Double.class.getClassLoader());
        this.scoreText = in.readString();
        this.ratings = (Integer) in.readValue(Integer.class.getClassLoader());
        this.reviews = (Integer) in.readValue(Integer.class.getClassLoader());
        this.histogram = in.readParcelable(Histogram.class.getClassLoader());
        this.price = (Integer) in.readValue(Integer.class.getClassLoader());
        this.free = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.currency = in.readString();
        this.priceText = in.readString();
        this.offersIAP = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.size = in.readString();
        this.androidVersion = in.readString();
        this.androidVersionText = in.readString();
        this.developer = in.readString();
        this.developerId = in.readString();
        this.developerEmail = in.readString();
        this.developerWebsite = in.readString();
        this.developerAddress = in.readString();
        this.privacyPolicy = in.readString();
        this.developerInternalID = in.readString();
        this.genre = in.readString();
        this.genreId = in.readString();
        this.icon = in.readString();
        this.headerImage = in.readString();
        this.screenshots = in.createStringArrayList();
        this.contentRating = in.readString();
        this.adSupported = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.released = in.readString();
        this.updated = (String) in.readString();
        this.version = in.readString();
        this.recentChanges = in.readString();
        this.comments = in.createStringArrayList();
        this.editorsChoice = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.appId = in.readString();
        this.url = in.readString();
        this.iAPRange = in.readString();
        this.video = in.readString();
        this.videoImage = in.readString();
    }

    public static final Parcelable.Creator<Result_> CREATOR = new Parcelable.Creator<Result_>() {
        @Override
        public Result_ createFromParcel(Parcel source) {
            return new Result_(source);
        }

        @Override
        public Result_[] newArray(int size) {
            return new Result_[size];
        }
    };
}
