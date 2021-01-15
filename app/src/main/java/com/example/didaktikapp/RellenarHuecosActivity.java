package com.example.didaktikapp;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;

public class RellenarHuecosActivity extends AppCompatActivity {

    private TextView option1, option2, option3, option4, option5, option6, choice1, choice2, choice3, choice4, choice1_2, choice2_2, choice3_2, choice4_2, choice5,choice6;
    private Integer contador = 0;
    private String name, nameOpcion;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llenar_huecos);

        //views to drag
//        option1 = (TextView)findViewById(R.id.option_1);
//        option2 = (TextView)findViewById(R.id.option_2);
//        option3 = (TextView)findViewById(R.id.option_3);
//        option4 = (TextView)findViewById(R.id.option_4);
//        option5 = (TextView)findViewById(R.id.option_5);
//        option6 = (TextView)findViewById(R.id.option_6);
//
//        //views to drop onto
//        choice1 = (TextView)findViewById(R.id.choice_1);
//        choice1_2 = (TextView)findViewById(R.id.choice_1_2);
//
//        choice2 = (TextView)findViewById(R.id.choice_2);
//        choice2_2 = (TextView)findViewById(R.id.choice_2_2);
//
//        choice3 = (TextView)findViewById(R.id.choice_3);
//        choice3_2 = (TextView)findViewById(R.id.choice_3_2);
//
//        choice4 = (TextView)findViewById(R.id.choice_4);
//        choice4_2 = (TextView)findViewById(R.id.choice_4_2);
//
//        choice5 = (TextView)findViewById(R.id.choice_5);
//        choice6 = (TextView)findViewById(R.id.choice_6);

        //set touch listeners
        option1.setOnTouchListener(new ChoiceTouchListener());
        option2.setOnTouchListener(new ChoiceTouchListener());
        option3.setOnTouchListener(new ChoiceTouchListener());
        option4.setOnTouchListener(new ChoiceTouchListener());
        option5.setOnTouchListener(new ChoiceTouchListener());
        option6.setOnTouchListener(new ChoiceTouchListener());

        //set drag listeners
        choice1.setOnDragListener(new ChoiceDragListener());
        choice2.setOnDragListener(new ChoiceDragListener());
        choice3.setOnDragListener(new ChoiceDragListener());
        choice4.setOnDragListener(new ChoiceDragListener());
        choice5.setOnDragListener(new ChoiceDragListener());
        choice6.setOnDragListener(new ChoiceDragListener());
    }

    /**
     * ChoiceTouchListener will handle touch events on draggable views
     *
     */
    private final class ChoiceTouchListener implements View.OnTouchListener {
        @SuppressLint("NewApi")
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                /*
                 * Drag details: we only need default behavior
                 * - clip data could be set to pass data as part of drag
                 * - shadow can be tailored
                 */
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                //start dragging the item touched
                view.startDrag(data, shadowBuilder, view, 0);
                return true;
            } else {
                return false;
            }
        }
    }


    /**
     * DragListener will handle dragged views being dropped on the drop area
     * - only the drop action will have processing added to it as we are not
     * - amending the default behavior for other parts of the drag process
     *
     */
    @SuppressLint("NewApi")
    private class ChoiceDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DROP:

                    //handle the dragged view being dropped over a drop view
                    View view = (View) event.getLocalState();
                    //view dragged item is being dropped on
                    TextView dropTarget = (TextView) v;
                    //view being dragged and dropped
                    TextView dropped = (TextView) view;
                    //checking whether first character of dropTarget equals first character of dropped

                    try {
                        name = getIDName(dropTarget, R.id.class);
                        nameOpcion = getIDName(dropped, R.id.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if((name.equals("choice_3") && nameOpcion.equals("option_1")) || (name.equals("choice_3_2") && nameOpcion.equals("option_1")) || (name.equals("choice_1")  &&  nameOpcion.equals("option_3")) || (name.equals("choice_1_2")  &&  nameOpcion.equals("option_3")) ||
                            (name.equals("choice_5") && nameOpcion.equals("option_2")) || (name.equals("choice_4") && nameOpcion.equals("option_4")) || (name.equals("choice_4_2") && nameOpcion.equals("option_4")) ||
                            (name.equals("choice_2") && nameOpcion.equals("option_6")) || (name.equals("choice_2_2") && nameOpcion.equals("option_6")) || (name.equals("choice_6") && nameOpcion.equals("option_5")))
                    {
                        //stop displaying the view where it was before it was dragged
                        view.setVisibility(View.INVISIBLE);

                        if (name.equals("choice_3_2")) {
                            choice3.setText(dropped.getText().toString());
                        } else if (name.equals("choice_1_2")) {
                            choice1.setText(dropped.getText().toString());
                        } else if (name.equals("choice_2_2")) {
                            choice2.setText(dropped.getText().toString());
                        } else if (name.equals("choice_4_2")) {
                            choice4.setText(dropped.getText().toString());
                        } else {
                            //update the text in the target view to reflect the data being dropped
                            dropTarget.setText(dropped.getText().toString());
                        }

                        //make it bold to highlight the fact that an item has been dropped
                        dropTarget.setTypeface(Typeface.DEFAULT_BOLD);
                        //if an item has already been dropped here, there will be a tag
                        Object tag = dropTarget.getTag();
                        //if there is already an item here, set it back visible in its original place
                        if(tag!=null)
                        {
                            //the tag is the view id already dropped here
                            int existingID = (Integer)tag;
                            //set the original view visible again
                            findViewById(existingID).setVisibility(View.VISIBLE);
                        }
                        //set the tag in the target view being dropped on - to the ID of the view being dropped
                        dropTarget.setTag(dropped.getId());
                        //remove setOnDragListener by setting OnDragListener to null, so that no further drag & dropping on this TextView can be done
                        dropTarget.setOnDragListener(null);

                        contador = contador + 1;

                        if (contador == 6) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(RellenarHuecosActivity.this);
                            builder.setTitle("Ganaste");
                            builder.setMessage("Felicidades!");
                            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // MensajeMisteriosoActivity.class;
                                }
                            });
                            builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    RellenarHuecosActivity.this.finish();
                                }
                            });
                            builder.show();
                        }
                    } else
                        //displays message if first character of dropTarget is not equal to first character of dropped
                        Toast.makeText(RellenarHuecosActivity.this, dropTarget.getText().toString() + "is not " + dropped.getText().toString(), Toast.LENGTH_LONG).show();
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    //no action necessary
                    break;
                default:
                    break;
            }
            return true;
        }
    }


    public void reset(View view)
    {
        option1.setVisibility(TextView.VISIBLE);
        option2.setVisibility(TextView.VISIBLE);
        option3.setVisibility(TextView.VISIBLE);

        choice1.setText("A for ");
        choice2.setText("O for ");
        choice3.setText("B for ");

        choice1.setTag(null);
        choice2.setTag(null);
        choice3.setTag(null);

        choice1.setTypeface(Typeface.DEFAULT);
        choice2.setTypeface(Typeface.DEFAULT);
        choice3.setTypeface(Typeface.DEFAULT);

        choice1.setOnDragListener(new ChoiceDragListener());
        choice2.setOnDragListener(new ChoiceDragListener());
        choice3.setOnDragListener(new ChoiceDragListener());
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.picture_to_word_24_color, menu);
//        return true;
//    }

    public static String getIDName(View view, Class<?> clazz) throws Exception {

        Integer id = view.getId();
        Field[] ids = clazz.getFields();
        for (int i = 0; i < ids.length; i++) {
            Object val = ids[i].get(null);
            if (val != null && val instanceof Integer
                    && ((Integer) val).intValue() == id.intValue()) {
                return ids[i].getName();
            }
        }

        return "";

    }
}
