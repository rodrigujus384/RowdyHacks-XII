package cs2.game;

import javafx.scene.image.Image;

public class ImageLoader {
    
    //load all images
    static final Image playerImg = new Image(ImageLoader.class.getResourceAsStream("/images/roadrunner.png"), MainApp.scale, MainApp.scale, true, true);
    static final Image playerImgLeft = new Image(ImageLoader.class.getResourceAsStream("/images/roadrunner2.png"), MainApp.scale, MainApp.scale, true, true);
    static final Image playerGif = new Image(ImageLoader.class.getResourceAsStream("/images/player_run.gif"), MainApp.scale, MainApp.scale, true, true);
    static final Image playerGifLeft = new Image(ImageLoader.class.getResourceAsStream("/images/player_run2.gif"), MainApp.scale, MainApp.scale, true, true);
    static final Image playerPFP = new Image(ImageLoader.class.getResourceAsStream("/images/roadrunner_pfp.png"));
    static final Image friendPFP = new Image(ImageLoader.class.getResourceAsStream("/images/friend_pfp.png"));
    static final Image NPCcontact = new Image(ImageLoader.class.getResourceAsStream("/images/friend_pfp.png"), 75, 75, true, true);
    static final Image Bubble1 = new Image(ImageLoader.class.getResourceAsStream("/images/speech_bubble.png"), 75, 75, true, true);
    static final Image StoreFloor = new Image(ImageLoader.class.getResourceAsStream("/images/store_floor1.png"), MainApp.scale, MainApp.scale, true, true);
    static final Image store1 = new Image(ImageLoader.class.getResourceAsStream("/images/liqa_sto.png"),250,250,true,true);
    static final Image store2 = new Image(ImageLoader.class.getResourceAsStream("/images/shindig_town.png"), 250,250,true,true);
    static final Image store3 = new Image(ImageLoader.class.getResourceAsStream("/images/snacs.png"),250,250,true,true);
    static final Image traverse = new Image(ImageLoader.class.getResourceAsStream("/images/player_run.gif"), 300, 300, true, true);
    static final Image HouseFloor1 = new Image(ImageLoader.class.getResourceAsStream("/images/house_floor1.png"), MainApp.scale, MainApp.scale, true, true);
    static final Image HouseWall1 = new Image(ImageLoader.class.getResourceAsStream("/images/house_wall1.png"), MainApp.scale, MainApp.scale, true, true);
    static final Image button = new Image(ImageLoader.class.getResourceAsStream("/images/button_bg.png"));
    static final Image Bubble2 = new Image(ImageLoader.class.getResourceAsStream("/images/speech_bubble_reverse.png"), 75, 75, true, true);
    static final Image text1 = new Image(ImageLoader.class.getResourceAsStream("/images/convo1.png"));
    static final Image text2 = new Image(ImageLoader.class.getResourceAsStream("/images/convo2.png"));
    static final Image text3 = new Image(ImageLoader.class.getResourceAsStream("/images/convo3.png"));
    static final Image text4 = new Image(ImageLoader.class.getResourceAsStream("/images/convo4.png"));
    static final Image text5 = new Image(ImageLoader.class.getResourceAsStream("/images/convo5.png"));
    static final Image one = new Image(ImageLoader.class.getResourceAsStream("/images/guest1.png"), MainApp.scale, MainApp.scale, true, true);
    static final Image two = new Image(ImageLoader.class.getResourceAsStream("/images/guest2.png"), MainApp.scale, MainApp.scale, true, true);
    static final Image three = new Image(ImageLoader.class.getResourceAsStream("/images/guest3.png"), MainApp.scale, MainApp.scale, true, true);
    static final Image four = new Image(ImageLoader.class.getResourceAsStream("/images/guest4.png"), MainApp.scale, MainApp.scale, true, true);
    static final Image five = new Image(ImageLoader.class.getResourceAsStream("/images/guest5.png"), MainApp.scale, MainApp.scale, true, true);
    static final Image six = new Image(ImageLoader.class.getResourceAsStream("/images/guest6.png"), MainApp.scale, MainApp.scale, true, true);
    static final Image seven = new Image(ImageLoader.class.getResourceAsStream("/images/guestCharlie.png"), MainApp.scale, MainApp.scale, true, true);
    static final Image eight = new Image(ImageLoader.class.getResourceAsStream("/images/guestJordan.png"), MainApp.scale, MainApp.scale, true, true);
    static final Image nine = new Image(ImageLoader.class.getResourceAsStream("/images/guestJustin.png"), MainApp.scale, MainApp.scale, true, true);
    static final Image ShelfImg = new Image(ImageLoader.class.getResourceAsStream("/images/store_shelf_empty_alarm_off.png"), MainApp.scale, MainApp.scale, true, true);
    static final Image birdHat = new Image(ImageLoader.class.getResourceAsStream("/images/player_with_hat.png"));

    //unused
    static final Image info = new Image(ImageLoader.class.getResourceAsStream("/images/information.png"));
    static final Image bars = new Image(ImageLoader.class.getResourceAsStream("/images/PartyBars.png"));
    static final Image ShelfImg2 = new Image(ImageLoader.class.getResourceAsStream("/images/store_shelf_empty_alarm_on.png"), MainApp.scale, MainApp.scale, true, true);
    static final Image sad = new Image(ImageLoader.class.getResourceAsStream("/images/sad_notif.png"));
    static final Image loud = new Image(ImageLoader.class.getResourceAsStream("/images/volume_loud_notif.png"));
    static final Image quiet = new Image(ImageLoader.class.getResourceAsStream("/images/volume_quiet_notif.png"));


}

