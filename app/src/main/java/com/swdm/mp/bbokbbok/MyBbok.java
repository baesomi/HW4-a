package com.swdm.mp.bbokbbok;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Bae Somi on 2016-06-01.
 */
public class MyBbok extends View {

    private Paint mPaint;
    private Bitmap mBbokBefore;
    private Bitmap mBbokAfter;
    private Bitmap[][] bbok = new Bitmap[5][4];

    //초기 화면 설정
    public void init() {
        mPaint = new Paint();

        //전과 후 그림 한꺼번에 받아오기
        mBbokBefore = BitmapFactory.decodeResource(getResources(), R.drawable.bbok_before_one);
        mBbokAfter = BitmapFactory.decodeResource(getResources(), R.drawable.bbok_after_one);
        int i, j;
        //미리 배열에 뽁뽁이 터지기 전 그림 넣어줌 (20개)
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 4; j++) {
                bbok[i][j] = mBbokBefore;
            }
        }
    }
    //생성자
    public MyBbok(Context c) {
        super(c);
        init();
    }
    //생성자
    public MyBbok(Context c, AttributeSet a) {
        super(c, a);
        init();
    }

    //invalidate 될 때 그려주는 부분
    protected void onDraw(Canvas canvas) {

        int i ,j,x,y;

        //뽁뽁이 그려지는 시작점
        x = 12;
        y = 12;

        //뽁뽁이 그려준다
        for(i=0 ; i<5;i++) {

            for (j = 0; j < 4; j++)
            {
            canvas.drawBitmap(bbok[i][j],x,y,mPaint);

                x+=157;//간격이 157

            }
            y+=157;//다음행
            x=12;//다음행을 그려주기위해 초기화

        }
//        canvas.drawBitmap(mBbokBefore, 0, 0, mPaint);


//        canvas.save(); // Save the current state



    }



    public boolean onTouchEvent(MotionEvent event) {

    float oX=12;
    float oY=12;
    float plus = 157+1;//간격 값 터치 혼란을 줄이기 위해 +1
    int changeX=0; //바뀐 열
    int i;

        //user 위치 받아오기
    float x = event.getX();
    float y = event.getY();
        //user가 눌렀을 때
    if(event.getAction() == MotionEvent.ACTION_UP)
    {
        //해당 x,y 영역을 눌렀다 뗐을 때

        //첫번째 행
        if(oY<=y && y<oY+plus){//12<=y<170

            for(i=0;i<4;i++){
                //해당 범위 터치 시
                if((x>=oX)&&((oX+plus)>=x)){
                    changeX = i;//바뀌는 열 저장

                }
                oX+=plus;
            }
            bbok[0][changeX] = mBbokAfter;// 터치하면 이미지 바뀜
            invalidate();// 그리기
        }

        //두번째 행
        oY+=plus;
        oX=12;
        if(oY<=y && y<oY+plus){//170<=y<328

            for(i=0;i<4;i++){
                //해당 범위 터치 시
                if((x>=oX)&&((oX+plus)>x)){
                    changeX = i;//바뀌는 열 저장

                }
                oX+=plus;
            }


            bbok[1][changeX] = mBbokAfter;// bbok[1][i] 터짐
            invalidate();// 그리기
        }

        //세번째 행
        oY+=plus;
        oX=12;
        if(oY<=y && y<oY+plus){

            for(i=0;i<4;i++){

                //해당 범위 터치 시
                if((x>=oX)&&((oX+plus)>x)){
                    changeX = i;//바뀌는 열 저장

                }
                oX+=plus;
            }

            bbok[2][changeX] = mBbokAfter;// bbok[2][i] 터짐
            invalidate();// 그리기
        }

//네번째 행
        oY+=plus;
        oX=12;
        if(oY<=y && y<oY+plus){

            for(i=0;i<4;i++){
                //해당 범위 터치 시
                if((x>=oX)&&((oX+plus)>x)){
                    changeX = i;//바뀌는 열 저장

                }
                oX+=plus;
            }

            bbok[3][changeX] = mBbokAfter;//bbok[3][i] 터짐
            invalidate();// 그리기
        }


//다섯번째 행
        oY+=plus;
        oX=12;
        if(oY<=y && y<oY+plus){

            for(i=0;i<4;i++){
                //해당 범위 터치 시
                if((x>=oX)&&((oX+plus)>x)){
                    changeX = i;//바뀌는 열 저장

                }
                oX+=plus;
            }


            bbok[4][changeX] = mBbokAfter;//bbok[4][i] 터짐
            invalidate();// 그리기
        }

    }

        return true;
    }


}



