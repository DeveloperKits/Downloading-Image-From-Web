# Downloading-Image-From-Web 
 In this main branch you can learn how to download image from web.

 ### In below you can some important code:
 
    ImageView downloadImage;
    downloadImage = (ImageView) findViewById(R.id.imageView);
    
    private class  ImageDownloader extends AsyncTask<String, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection Connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = Connection.getInputStream();
                Bitmap myBitMap = BitmapFactory.decodeStream(inputStream);
                return myBitMap;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void DownloadingImage(View view) {

        ImageDownloader task = new ImageDownloader();
        Bitmap myImage;
        try {
            myImage = task.execute("https://upload.wikimedia.org/wikipedia/commons/thumb/8/8a/Pokemon_Go_Tr%C3%A4sk%C3%A4nda_g%C3%A5rd.jpg/1200px-Pokemon_Go_Tr%C3%A4sk%C3%A4nda_g%C3%A5rd.jpg").get();
            downloadImage.setImageBitmap(myImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
# trVendorack branch
  In this branch you can show some android project like:
  + Animation
  + AppBrainTrainer
  + AppEggTimer
  + GridLayout
  + GuessNumber
  + ListView
  + NumberShapes
  + TicTacToe
  + TimesTable
  + WebContent
  
  
## Thank You
