package com.sonetsagor.towerofhanoi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.datatype.Duration;

public class Tower1Activity extends AppCompatActivity {
    LinearLayout mainlayout, layout1, layout2, layout3, ll11, ll12, ll13, ll21, ll22, ll23, ll31, ll32, ll33;
    ImageView img11, img12, img13, img21, img22, img23, img31, img32, img33;
    TextView counttext;
    boolean red11 = true, red12 = false, red13 = false, red21 = false, red22 = false, red23 = false, red31 = false, red32 = false, red33 = false;
    boolean blue13 = true, blue23 = false, blue33 = false;
    boolean green12 = true, green13 = false, green22 = false, green23 = false, green32 = false, green33 = false;
    int position11 = 1, position12 = 1, position13 = 1, position21 = 0, position22 = 0, position23 = 0, position31 = 0, position32 = 0, position33 = 0;
    int countmovieeasy=0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tower1);
        counttext=findViewById(R.id.move_id_easyMode);
        mainlayout = findViewById(R.id.mainlayoutid);
        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);
        ll11 = findViewById(R.id.ll11);
        ll12 = findViewById(R.id.ll12);
        ll13 = findViewById(R.id.ll13);
        ll21 = findViewById(R.id.ll21);
        ll22 = findViewById(R.id.ll22);
        ll23 = findViewById(R.id.ll23);
        ll31 = findViewById(R.id.ll31);
        ll32 = findViewById(R.id.ll32);
        ll33 = findViewById(R.id.ll33);
        img11 = findViewById(R.id.img11);
        img12 = findViewById(R.id.img12);
        img13 = findViewById(R.id.img13);
        img21 = findViewById(R.id.img21);
        img22 = findViewById(R.id.img22);
        img23 = findViewById(R.id.img23);
        img31 = findViewById(R.id.img31);
        img32 = findViewById(R.id.img32);
        img33 = findViewById(R.id.img33);

        img11.setImageResource(R.drawable.disc1r);
        img12.setImageResource(R.drawable.disc2r);
        img13.setImageResource(R.drawable.disc3r);

        img11.setOnTouchListener(onTouchListener);
        img12.setOnTouchListener(onTouchListener);
        img13.setOnTouchListener(onTouchListener);
        img21.setOnTouchListener(onTouchListener);
        img22.setOnTouchListener(onTouchListener);
        img23.setOnTouchListener(onTouchListener);
        img31.setOnTouchListener(onTouchListener);
        img32.setOnTouchListener(onTouchListener);
        img33.setOnTouchListener(onTouchListener);

        mainlayout.setOnDragListener(dragListener);
        layout1.setOnDragListener(dragListener);
        layout2.setOnDragListener(dragListener);
        layout3.setOnDragListener(dragListener);
        ll11.setOnDragListener(dragListener);
        ll12.setOnDragListener(dragListener);
        ll13.setOnDragListener(dragListener);
        ll21.setOnDragListener(dragListener);
        ll22.setOnDragListener(dragListener);
        ll23.setOnDragListener(dragListener);
        ll31.setOnDragListener(dragListener);
        ll32.setOnDragListener(dragListener);
        ll33.setOnDragListener(dragListener);
    }

    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myshadowbuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, myshadowbuilder, view, 0);
            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.img11 && v.getId() == R.id.layout2 || view.getId() == R.id.img11 && v.getId() == R.id.layout3) {
                        if (v.getId() == R.id.layout2) {
                            if (position23 == 0) {
                                img11.setVisibility(View.GONE);
                                img23.setVisibility(View.VISIBLE);
                                img23.setImageResource(R.drawable.disc1r);
                                red11 = false;
                                red23 = true;
                                position23 = 1;
                                position11 = 0;
                            } else if (position22 == 0) {
                                img11.setVisibility(View.GONE);
                                img22.setVisibility(View.VISIBLE);
                                img22.setImageResource(R.drawable.disc1r);
                                red22 = true;
                                red11 = false;
                                position22 = 1;
                                position11 = 0;
                            } else {
                                img11.setVisibility(View.GONE);
                                img21.setVisibility(View.VISIBLE);
                                img21.setImageResource(R.drawable.disc1r);
                                red21 = true;
                                red11 = false;
                                position21 = 1;
                                position11 = 0;
                            }
                        }
                        if (v.getId() == R.id.layout3) {
                            if (position33 == 0) {
                                img11.setVisibility(View.GONE);
                                img33.setVisibility(View.VISIBLE);
                                img33.setImageResource(R.drawable.disc1r);
                                red33 = true;
                                red11 = false;
                                position33 = 1;
                                position11 = 0;
                            } else if (position32 == 0) {
                                img11.setVisibility(View.GONE);
                                img32.setVisibility(View.VISIBLE);
                                img32.setImageResource(R.drawable.disc1r);
                                position32 = 1;
                                red11 = false;
                                red32 = true;
                                position11 = 0;
                            } else {
                                img11.setVisibility(View.GONE);
                                img31.setVisibility(View.VISIBLE);
                                img31.setImageResource(R.drawable.disc1r);
                                position31 = 1;
                                red11 = false;
                                red31 = true;
                                position11 = 0;
                            }
                        }
                    }//done position11
                    if (view.getId() == R.id.img12 && v.getId() == R.id.layout2 || view.getId() == R.id.img12 && v.getId() == R.id.layout3) {
                            if (v.getId() == R.id.layout2) {
                                if (position23 == 0) {
                                    if (green12) {
                                        if(!red11) {
                                            img12.setVisibility(View.GONE);
                                            img23.setVisibility(View.VISIBLE);
                                            img23.setImageResource(R.drawable.disc2r);
                                            green12 = false;
                                            green23 = true;
                                            position23 = 1;
                                            position12 = 0;
                                        }
                                    } else {
                                        if(red12&&!red11) {
                                            img12.setVisibility(View.GONE);
                                            img23.setVisibility(View.VISIBLE);
                                            img23.setImageResource(R.drawable.disc1r);
                                            red23 = true;
                                            red12 = false;
                                            position23 = 1;
                                            position12 = 0;
                                        }
                                    }
                                } else {
                                    if (position22 == 0) {
                                        if (green12) {
                                            if(!red11){
                                                if(!red23){
                                                    img12.setVisibility(View.GONE);
                                                    img22.setVisibility(View.VISIBLE);
                                                    img22.setImageResource(R.drawable.disc2r);
                                                    green12 = false;
                                                    green22 = true;
                                                    position22 = 1;
                                                    position12 = 0;
                                                }
                                            }
                                        } else {
                                            if(!red11&&red12&&!red23){
                                                img12.setVisibility(View.GONE);
                                                img22.setVisibility(View.VISIBLE);
                                                img22.setImageResource(R.drawable.disc1r);
                                                red22 = true;
                                                red12 = false;
                                                position22 = 1;
                                                position12 = 0;
                                            }
                                        }
                                    } else {
                                        if (red12&&!red23&&!red22&&!red11) {
                                            img12.setVisibility(View.GONE);
                                            img21.setVisibility(View.VISIBLE);
                                            img21.setImageResource(R.drawable.disc1r);
                                            red21 = true;
                                            red12 = false;
                                            position21 = 1;
                                            position12 = 0;
                                        }
                                    }
                                }
                            }
                            if (v.getId() == R.id.layout3) {
                                if (position33 == 0) {
                                    if (green12) {
                                        if(!red11) {
                                            img12.setVisibility(View.GONE);
                                            img33.setVisibility(View.VISIBLE);
                                            img33.setImageResource(R.drawable.disc2r);
                                            green33 = true;
                                            green12 = false;
                                            position33 = 1;
                                            position12 = 0;
                                        }
                                    } else {
                                        if(red12&&!red11) {
                                            img12.setVisibility(View.GONE);
                                            img33.setVisibility(View.VISIBLE);
                                            img33.setImageResource(R.drawable.disc1r);
                                            red33 = true;
                                            red12 = false;
                                            position33 = 1;
                                            position12 = 0;
                                        }
                                    }
                                } else {
                                    if (position32 == 0) {
                                        if (green12) {
                                            if(!red11&&!red33) {
                                                img12.setVisibility(View.GONE);
                                                img32.setVisibility(View.VISIBLE);
                                                img32.setImageResource(R.drawable.disc2r);
                                                green12 = false;
                                                green32 = true;
                                                position32 = 1;
                                                position12 = 0;
                                            }
                                        } else {
                                            if(!red11&&!red33&&red12)
                                            img12.setVisibility(View.GONE);
                                            img32.setVisibility(View.VISIBLE);
                                            img32.setImageResource(R.drawable.disc1r);
                                            red32 = true;
                                            red12 = false;
                                            position32 = 1;
                                            position12 = 0;
                                        }
                                    } else {
                                        if (red12&&!red11&&!red33&&!red32) {
                                            img12.setVisibility(View.GONE);
                                            img31.setVisibility(View.VISIBLE);
                                            img31.setImageResource(R.drawable.disc1r);
                                            red31 = true;
                                            red12 = false;
                                            position31 = 1;
                                            position12 = 0;
                                        }
                                    }
                                }
                            }
                    }
                    if (view.getId() == R.id.img13 && v.getId() == R.id.layout2 || view.getId() == R.id.img13 && v.getId() == R.id.layout3) {
                        if(!red11){
                            if (v.getId() == R.id.layout2) {
                                if (position23 == 0) {
                                    if (blue13&&!green12&&!red12&&!red11) {
                                        img13.setVisibility(View.GONE);
                                        img23.setVisibility(View.VISIBLE);
                                        img23.setImageResource(R.drawable.disc3r);
                                        blue23 = true;
                                        blue13 = false;
                                        position23 = 1;
                                        position13 = 0;
                                    } else if (green13&&!red12&&!red11) {
                                        img13.setVisibility(View.GONE);
                                        img23.setVisibility(View.VISIBLE);
                                        img23.setImageResource(R.drawable.disc2r);
                                        green23 = true;
                                        green13 = false;
                                        position23 = 1;
                                        position13 = 0;
                                    } else {
                                        if(red13&&!green12&&!red12&&!red11) {
                                            img13.setVisibility(View.GONE);
                                            img23.setVisibility(View.VISIBLE);
                                            img23.setImageResource(R.drawable.disc1r);
                                            red23 = true;
                                            red13 = false;
                                            position23 = 1;
                                            position13 = 0;
                                        }
                                    }
                                } else {
                                    if (position22 == 0) {
                                        if (green13) {
                                            if(!green12&&!red13&&!red12&&!red11&&!red23) {
                                                img13.setVisibility(View.GONE);
                                                img22.setVisibility(View.VISIBLE);
                                                img22.setImageResource(R.drawable.disc2r);
                                                green22 = true;
                                                green13 = false;
                                                position22 = 1;
                                                position13 = 0;
                                            }
                                        }
                                        else {
                                            if (red13 && !red12 && !red11 && !red23) {
                                                img13.setVisibility(View.GONE);
                                                img22.setVisibility(View.VISIBLE);
                                                img22.setImageResource(R.drawable.disc1r);
                                                red22 = true;
                                                red13 = false;
                                                position22 = 1;
                                                position13 = 0;
                                            }
                                        }
                                    } else {
                                        if (red13&&!red23&&!red22&&!red11&&!red12) {
                                            img13.setVisibility(View.GONE);
                                            img21.setVisibility(View.VISIBLE);
                                            img21.setImageResource(R.drawable.disc1r);
                                            red21 = true;
                                            red13 = false;
                                            position21 = 1;
                                            position13 = 0;
                                        }
                                    }
                                }
                            }
                            if (v.getId() == R.id.layout3) {
                                if (position33 == 0) {
                                    if (blue13&&!green12&&!red12&&!red11) {
                                        img13.setVisibility(View.GONE);
                                        img33.setVisibility(View.VISIBLE);
                                        img33.setImageResource(R.drawable.disc3r);
                                        blue33 = true;
                                        blue13 = false;
                                        position33 = 1;
                                        position13 = 0;
                                    } else if (green13&&!red12&&!red11) {
                                        img13.setVisibility(View.GONE);
                                        img33.setVisibility(View.VISIBLE);
                                        img33.setImageResource(R.drawable.disc2r);
                                        green33 = true;
                                        green13 = false;
                                        position33 = 1;
                                        position13 = 0;
                                    } else {
                                        if(red13&&!green12&&!red12&&!red11) {
                                            img13.setVisibility(View.GONE);
                                            img33.setVisibility(View.VISIBLE);
                                            img33.setImageResource(R.drawable.disc1r);
                                            red33 = true;
                                            red13 = false;
                                            position33 = 1;
                                            position13 = 0;
                                        }
                                    }
                                } else {
                                    if (position32 == 0) {
                                        if (!red33 && green13&&!red12&&!red11&&!green12) {
                                            img13.setVisibility(View.GONE);
                                            img32.setVisibility(View.VISIBLE);
                                            img32.setImageResource(R.drawable.disc2r);
                                            green32 = true;
                                            green13 = false;
                                            position32 = 1;
                                            position13 = 0;
                                        }
                                        else if (red13&&!red12&&!red11&&!red33) {
                                            img13.setVisibility(View.GONE);
                                            img32.setVisibility(View.VISIBLE);
                                            img32.setImageResource(R.drawable.disc1r);
                                            red32 = true;
                                            red13 = false;
                                            position32 = 1;
                                            position13 = 0;
                                        }
                                    } else {
                                        if (red13&&!red11&&!red12&&!red33&&!red32) {
                                            img13.setVisibility(View.GONE);
                                            img31.setVisibility(View.VISIBLE);
                                            img31.setImageResource(R.drawable.disc1r);
                                            red31 = true;
                                            red13 = false;
                                            position31 = 1;
                                            position13 = 0;
                                            Toast.makeText(getApplicationContext(),"You Win",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    //done
                    if (view.getId() == R.id.img21 && v.getId() == R.id.layout1 || view.getId() == R.id.img21 && v.getId() == R.id.layout3) {
                        if (v.getId() == R.id.layout1) {
                            if (position13 == 0) {
                                if(red21) {
                                    img21.setVisibility(View.GONE);
                                    img13.setVisibility(View.VISIBLE);
                                    img13.setImageResource(R.drawable.disc1r);
                                    red21 = false;
                                    red13 = true;
                                    position13 = 1;
                                    position21 = 0;
                                }
                            } else if (position12 == 0) {
                                if(red21&&!red13) {
                                    img21.setVisibility(View.GONE);
                                    img12.setVisibility(View.VISIBLE);
                                    img12.setImageResource(R.drawable.disc1r);
                                    position12 = 1;
                                    red12 = true;
                                    red21 = false;
                                    position21 = 0;
                                }
                            } else {
                                if(red21&&!red13&&!red12) {
                                    img21.setVisibility(View.GONE);
                                    img11.setVisibility(View.VISIBLE);
                                    img11.setImageResource(R.drawable.disc1r);
                                    position11 = 1;
                                    red11 = true;
                                    red21 = false;
                                    position21 = 0;
                                }
                            }
                        }
                        if (v.getId() == R.id.layout3) {
                            if (position33 == 0) {
                                if(red21) {
                                    img21.setVisibility(View.GONE);
                                    img33.setVisibility(View.VISIBLE);
                                    img33.setImageResource(R.drawable.disc1r);
                                    position33 = 1;
                                    red33 = true;
                                    red21 = false;
                                    position21 = 0;
                                }
                            } else if (position32 == 0) {
                                if(red21&&!red33) {
                                    img21.setVisibility(View.GONE);
                                    img32.setVisibility(View.VISIBLE);
                                    img32.setImageResource(R.drawable.disc1r);
                                    position32 = 1;
                                    red32 = true;
                                    red21 = false;
                                    position21 = 0;
                                }
                            } else {
                                if (red21&&!red33&&!red32) {
                                    img21.setVisibility(View.GONE);
                                    img31.setVisibility(View.VISIBLE);
                                    img31.setImageResource(R.drawable.disc1r);
                                    position31 = 1;
                                    red31 = true;
                                    red21 = false;
                                    position21 = 0;
                                    //ai khane aslei game over
                                }
                            }
                        }
                    }//done position21
                    if (view.getId() == R.id.img22 && v.getId() == R.id.layout1 || view.getId() == R.id.img22 && v.getId() == R.id.layout3) {
                            if (v.getId() == R.id.layout1) {
                                if (position13 == 0) {
                                    if (green22) {
                                        if(!red21) {
                                            img22.setVisibility(View.GONE);
                                            img13.setVisibility(View.VISIBLE);
                                            img13.setImageResource(R.drawable.disc2r);
                                            green22 = false;
                                            green13 = true;
                                            position13 = 1;
                                            position22 = 0;
                                        }
                                    } else {
                                        if(red22&&!red21) {
                                            img22.setVisibility(View.GONE);
                                            img13.setVisibility(View.VISIBLE);
                                            img13.setImageResource(R.drawable.disc1r);
                                            red13 = true;
                                            red22 = false;
                                            position13 = 1;
                                            position22 = 0;
                                        }
                                    }
                                } else {
                                    if (position12 == 0) {
                                        if (green22&&!red21&&!red13) {
                                            img22.setVisibility(View.GONE);
                                            img12.setVisibility(View.VISIBLE);
                                            img12.setImageResource(R.drawable.disc2r);
                                            green22 = false;
                                            green12 = true;
                                            position12 = 1;
                                            position22 = 0;
                                        } else {
                                            if(red22&&!red21&&!red13) {
                                                img22.setVisibility(View.GONE);
                                                img12.setVisibility(View.VISIBLE);
                                                img12.setImageResource(R.drawable.disc1r);
                                                red12 = true;
                                                red22 = false;
                                                position12 = 1;
                                                position22 = 0;
                                            }
                                        }
                                    } else {
                                        if (red22&&!red13&&!red12) {
                                            img22.setVisibility(View.GONE);
                                            img11.setVisibility(View.VISIBLE);
                                            img11.setImageResource(R.drawable.disc1r);
                                            red11 = true;
                                            red22 = false;
                                            position11 = 1;
                                            position22 = 0;
                                        }
                                    }
                                }
                            }
                            if (v.getId() == R.id.layout3) {
                                if (position33 == 0) {
                                    if (green22) {
                                        if(!red21) {
                                            img22.setVisibility(View.GONE);
                                            img33.setVisibility(View.VISIBLE);
                                            img33.setImageResource(R.drawable.disc2r);
                                            green33 = true;
                                            green22 = false;
                                            position33 = 1;
                                            position22 = 0;
                                        }
                                    } else {
                                        if(red22) {
                                            img22.setVisibility(View.GONE);
                                            img33.setVisibility(View.VISIBLE);
                                            img33.setImageResource(R.drawable.disc1r);
                                            red33 = true;
                                            red22 = false;
                                            position33 = 1;
                                            position22 = 0;
                                        }
                                    }
                                } else {
                                    if (position32 == 0) {
                                        if (green22) {
                                            if(!red21&&!red33) {
                                                img22.setVisibility(View.GONE);
                                                img32.setVisibility(View.VISIBLE);
                                                img32.setImageResource(R.drawable.disc2r);
                                                green22 = false;
                                                green32 = true;
                                                position32 = 1;
                                                position22 = 0;
                                            }
                                        } else {
                                            if(red22&&!red33) {
                                                img22.setVisibility(View.GONE);
                                                img32.setVisibility(View.VISIBLE);
                                                img32.setImageResource(R.drawable.disc1r);
                                                red32 = true;
                                                red22 = false;
                                                position32 = 1;
                                                position22 = 0;
                                            }
                                        }
                                    } else {
                                        if (red22&&!red33&&!red32) {
                                            img22.setVisibility(View.GONE);
                                            img31.setVisibility(View.VISIBLE);
                                            img31.setImageResource(R.drawable.disc1r);
                                            red31 = true;
                                            red22 = false;
                                            position31 = 1;
                                            position22 = 0;
                                        }
                                    }
                                }
                            }
                    }
                    if (view.getId() == R.id.img23 && v.getId() == R.id.layout1 || view.getId() == R.id.img23 && v.getId() == R.id.layout3) {
                           if (v.getId() == R.id.layout1) {
                               if (position13 == 0) {
                                   if (blue23) {
                                       if (!green23&&!green22&&!red23&&!red22&&!red21) {
                                           img23.setVisibility(View.GONE);
                                           img13.setVisibility(View.VISIBLE);
                                           img13.setImageResource(R.drawable.disc3r);
                                           blue13 = true;
                                           blue23 = false;
                                           position13 = 1;
                                           position23 = 0;
                                       }
                                   } else if (green23) {
                                       if (!green22&&!red23&&!red22&&!red21) {
                                           img23.setVisibility(View.GONE);
                                           img13.setVisibility(View.VISIBLE);
                                           img13.setImageResource(R.drawable.disc2r);
                                           green13 = true;
                                           green23 = false;
                                           position13 = 1;
                                           position23 = 0;
                                       }
                                   } else {
                                       if(red23) {
                                           img23.setVisibility(View.GONE);
                                           img13.setVisibility(View.VISIBLE);
                                           img13.setImageResource(R.drawable.disc1r);
                                           red13 = true;
                                           red23 = false;
                                           position13 = 1;
                                           position23 = 0;
                                       }
                                   }
                               } else {
                                   if (position12 == 0) {
                                       if (green23) {
                                           if (!green22&&!red23&&!red22&&!red21&&!red13) {
                                               img23.setVisibility(View.GONE);
                                               img12.setVisibility(View.VISIBLE);
                                               img12.setImageResource(R.drawable.disc2r);
                                               green12 = true;
                                               green23 = false;
                                               position12 = 1;
                                               position23 = 0;
                                           }
                                       }
                                       else if (red23) {
                                           if (!red22&&!red21) {
                                               img23.setVisibility(View.GONE);
                                               img12.setVisibility(View.VISIBLE);
                                               img12.setImageResource(R.drawable.disc1r);
                                               red12 = true;
                                               red23 = false;
                                               position12 = 1;
                                               position23 = 0;
                                           }
                                       }
                                   } else {
                                       if (red23) {
                                           img23.setVisibility(View.GONE);
                                           img11.setVisibility(View.VISIBLE);
                                           img11.setImageResource(R.drawable.disc1r);
                                           red11 = true;
                                           red23 = false;
                                           position11 = 1;
                                           position23 = 0;
                                       }
                                   }
                               }
                           }
                           if (v.getId() == R.id.layout3) {
                               if (position33 == 0) {
                                   if (blue23) {
                                       if (!green23&&!green22&&!red23&&!red22&&!red21) {
                                           img23.setVisibility(View.GONE);
                                           img33.setVisibility(View.VISIBLE);
                                           img33.setImageResource(R.drawable.disc3r);
                                           blue33 = true;
                                           blue23 = false;
                                           position33 = 1;
                                           position23 = 0;
                                       }
                                   } else if (green23) {
                                       if (!green22&&!red23&&!red22&&!red21) {
                                           img23.setVisibility(View.GONE);
                                           img33.setVisibility(View.VISIBLE);
                                           img33.setImageResource(R.drawable.disc2r);
                                           green33 = true;
                                           green23 = false;
                                           position33 = 1;
                                           position23 = 0;
                                       }
                                   } else {
                                       if (red23) {
                                           img23.setVisibility(View.GONE);
                                           img33.setVisibility(View.VISIBLE);
                                           img33.setImageResource(R.drawable.disc1r);
                                           red33 = true;
                                           red23 = false;
                                           position33 = 1;
                                           position23 = 0;
                                       }
                                   }
                               } else {
                                   if (position32 == 0) {
                                       if (green23) {
                                           if (!green22&&!red23&&!red22&&!red21&&!red33) {
                                               img23.setVisibility(View.GONE);
                                               img32.setVisibility(View.VISIBLE);
                                               img32.setImageResource(R.drawable.disc2r);
                                               green32 = true;
                                               green23 = false;
                                               position32 = 1;
                                               position23 = 0;
                                           }
                                       }
                                       else if (red23) {
                                           if (!red22&&!red21) {
                                               img23.setVisibility(View.GONE);
                                               img32.setVisibility(View.VISIBLE);
                                               img32.setImageResource(R.drawable.disc1r);
                                               red32 = true;
                                               red23 = false;
                                               position32 = 1;
                                               position23 = 0;
                                           }
                                       }
                                   } else {
                                       if (red23) {
                                           img23.setVisibility(View.GONE);
                                           img31.setVisibility(View.VISIBLE);
                                           img31.setImageResource(R.drawable.disc1r);
                                           red31 = true;
                                           red23 = false;
                                           position31 = 1;
                                           position23 = 0;
                                           Toast.makeText(getApplicationContext(),"You Win",Toast.LENGTH_SHORT).show();
                                       }
                                   }
                               }
                           }
                    }
                    //done
                    if (view.getId() == R.id.img31 && v.getId() == R.id.layout1 || view.getId() == R.id.img31 && v.getId() == R.id.layout2) {
                        if (v.getId() == R.id.layout1) {
                            if (position13 == 0) {
                                if(red31) {
                                    img31.setVisibility(View.GONE);
                                    img13.setVisibility(View.VISIBLE);
                                    img13.setImageResource(R.drawable.disc1r);
                                    red31 = false;
                                    red13 = true;
                                    position13 = 1;
                                    position31 = 0;
                                }
                            } else if (position12 == 0) {
                                if(red31&&!red13) {
                                    img31.setVisibility(View.GONE);
                                    img12.setVisibility(View.VISIBLE);
                                    img12.setImageResource(R.drawable.disc1r);
                                    position12 = 1;
                                    red31 = false;
                                    red12 = true;
                                    position31 = 0;
                                }
                            } else {
                                if(red31&&!red13&&!red12) {
                                    img31.setVisibility(View.GONE);
                                    img11.setVisibility(View.VISIBLE);
                                    img11.setImageResource(R.drawable.disc1r);
                                    position11 = 1;
                                    red31 = false;
                                    red11 = true;
                                    position31 = 0;
                                }
                            }
                        }
                        if (v.getId() == R.id.layout2) {
                            if (position23 == 0) {
                                if(red31) {
                                    img31.setVisibility(View.GONE);
                                    img23.setVisibility(View.VISIBLE);
                                    img23.setImageResource(R.drawable.disc1r);
                                    position23 = 1;
                                    red31 = false;
                                    red23 = true;
                                    position31 = 0;
                                }
                            } else if (position22 == 0) {
                                if(red31&&!red23) {
                                    img31.setVisibility(View.GONE);
                                    img22.setVisibility(View.VISIBLE);
                                    img22.setImageResource(R.drawable.disc1r);
                                    position22 = 1;
                                    red31 = false;
                                    red22 = true;
                                    position31 = 0;
                                }
                            } else {
                                if(red31&&!red23&&!red22) {
                                    img31.setVisibility(View.GONE);
                                    img21.setVisibility(View.VISIBLE);
                                    img21.setImageResource(R.drawable.disc1r);
                                    position21 = 1;
                                    red31 = false;
                                    red21 = true;
                                    position31 = 0;
                                }
                            }
                        }
                    }//done position31
                    if (view.getId() == R.id.img32 && v.getId() == R.id.layout1 || view.getId() == R.id.img32 && v.getId() == R.id.layout2 || view.getId() == R.id.img32 && v.getId() == R.id.layout3) {
                            if (v.getId() == R.id.layout1) {
                                if (position13 == 0) {
                                    if (green32) {
                                        if(!red31) {
                                            img32.setVisibility(View.GONE);
                                            img13.setVisibility(View.VISIBLE);
                                            img13.setImageResource(R.drawable.disc2r);
                                            green32 = false;
                                            green13 = true;
                                            position13 = 1;
                                            position32 = 0;
                                        }
                                    } else if(red32) {
                                            img32.setVisibility(View.GONE);
                                            img13.setVisibility(View.VISIBLE);
                                            img13.setImageResource(R.drawable.disc1r);
                                            red13 = true;
                                            red32 = false;
                                            position13 = 1;
                                            position32 = 0;
                                        }
                                } else {
                                    if (position12 == 0) {
                                        if(green32){
                                        if (!red13&&!red31) {
                                            img32.setVisibility(View.GONE);
                                            img12.setVisibility(View.VISIBLE);
                                            img12.setImageResource(R.drawable.disc2r);
                                            green32 = false;
                                            green12 = true;
                                            position12 = 1;
                                            position32 = 0;
                                        }
                                        } else {
                                            if(red32&&!red13) {
                                                img32.setVisibility(View.GONE);
                                                img12.setVisibility(View.VISIBLE);
                                                img12.setImageResource(R.drawable.disc1r);
                                                red12 = true;
                                                red32 = false;
                                                position12 = 1;
                                                position32 = 0;
                                            }
                                        }
                                    } else {
                                        if (red32&&!red31) {
                                            img32.setVisibility(View.GONE);
                                            img11.setVisibility(View.VISIBLE);
                                            img11.setImageResource(R.drawable.disc1r);
                                            red11 = true;
                                            red32 = false;
                                            position11 = 1;
                                            position32 = 0;
                                        }
                                    }
                                }
                            }
                            if (v.getId() == R.id.layout2) {
                                if (position23 == 0) {
                                    if (green32) {
                                        if(!red31) {
                                            img32.setVisibility(View.GONE);
                                            img23.setVisibility(View.VISIBLE);
                                            img23.setImageResource(R.drawable.disc2r);
                                            green32 = false;
                                            green23 = true;
                                            position23 = 1;
                                            position32 = 0;
                                        }
                                    } else {
                                        if(red32) {
                                            img32.setVisibility(View.GONE);
                                            img23.setVisibility(View.VISIBLE);
                                            img23.setImageResource(R.drawable.disc1r);
                                            red23 = true;
                                            red32 = false;
                                            position23 = 1;
                                            position32 = 0;
                                        }
                                    }
                                } else {
                                    if (position22 == 0) {
                                        if(green32) {
                                            if (!red23 && !red31) {
                                                img32.setVisibility(View.GONE);
                                                img22.setVisibility(View.VISIBLE);
                                                img22.setImageResource(R.drawable.disc2r);
                                                green32 = false;
                                                green22 = true;
                                                position22 = 1;
                                                position32 = 0;
                                            }
                                        }else {
                                            if(red32) {
                                                img32.setVisibility(View.GONE);
                                                img22.setVisibility(View.VISIBLE);
                                                img22.setImageResource(R.drawable.disc1r);
                                                red22 = true;
                                                red32 = false;
                                                position22 = 1;
                                                position32 = 0;
                                            }
                                        }
                                    } else {
                                        if (red32) {
                                            img32.setVisibility(View.GONE);
                                            img21.setVisibility(View.VISIBLE);
                                            img21.setImageResource(R.drawable.disc1r);
                                            red21 = true;
                                            red32 = false;
                                            position21 = 1;
                                            position32 = 0;
                                        }
                                    }
                                }
                            }
                    }
                    if (view.getId() == R.id.img33 && v.getId() == R.id.layout1 || view.getId() == R.id.img33 && v.getId() == R.id.layout2 || view.getId() == R.id.img33 && v.getId() == R.id.layout3) {
                           if (v.getId() == R.id.layout1) {
                               if (position13 == 0) {
                                   if (blue33) {
                                       if(!red33&&!green33&&!red32&&!red31&&!green32) {
                                           img33.setVisibility(View.GONE);
                                           img13.setVisibility(View.VISIBLE);
                                           img13.setImageResource(R.drawable.disc3r);
                                           blue13 = true;
                                           blue33 = false;
                                           position13 = 1;
                                           position33 = 0;
                                       }
                                   } else if (green33) {
                                       if(!red33&&!red32&&!red31) {
                                           img33.setVisibility(View.GONE);
                                           img13.setVisibility(View.VISIBLE);
                                           img13.setImageResource(R.drawable.disc2r);
                                           green13 = true;
                                           green33 = false;
                                           position13 = 1;
                                           position33 = 0;
                                       }
                                   } else {
                                       if(red33) {
                                           img33.setVisibility(View.GONE);
                                           img13.setVisibility(View.VISIBLE);
                                           img13.setImageResource(R.drawable.disc1r);
                                           red13 = true;
                                           red33 = false;
                                           position13 = 1;
                                           position33 = 0;
                                       }
                                   }
                               } else {
                                   if (position12 == 0) {
                                       if(green33) {
                                           if (!red13&&!red32&&!red31&&!blue33) {
                                               img33.setVisibility(View.GONE);
                                               img12.setVisibility(View.VISIBLE);
                                               img12.setImageResource(R.drawable.disc2r);
                                               green12 = true;
                                               green33 = false;
                                               position12 = 1;
                                               position33 = 0;
                                           }
                                       }else {
                                           if (red33) {
                                               img33.setVisibility(View.GONE);
                                               img12.setVisibility(View.VISIBLE);
                                               img12.setImageResource(R.drawable.disc1r);
                                               red12 = true;
                                               red33 = false;
                                               position12 = 1;
                                               position33 = 0;
                                           }
                                       }
                                   } else {
                                       if (red33) {
                                           img33.setVisibility(View.GONE);
                                           img11.setVisibility(View.VISIBLE);
                                           img11.setImageResource(R.drawable.disc1r);
                                           red11 = true;
                                           red33 = false;
                                           position11 = 1;
                                           position33 = 0;
                                       }
                                   }
                               }
                           }
                           if (v.getId() == R.id.layout2) {
                               if (position23 == 0) {
                                   if (blue33) {
                                       if(!red33&&!red32&&!red31&&!green33&&!green32) {
                                           img33.setVisibility(View.GONE);
                                           img23.setVisibility(View.VISIBLE);
                                           img23.setImageResource(R.drawable.disc3r);
                                           blue23 = true;
                                           blue33 = false;
                                           position23 = 1;
                                           position33 = 0;
                                       }
                                   } else if (green33) {
                                       if(!red33&&!red32&&!red31&&!green32) {
                                           img33.setVisibility(View.GONE);
                                           img23.setVisibility(View.VISIBLE);
                                           img23.setImageResource(R.drawable.disc2r);
                                           green23 = true;
                                           green33 = false;
                                           position23 = 1;
                                           position33 = 0;
                                       }
                                   } else {
                                       if(red33) {
                                           img33.setVisibility(View.GONE);
                                           img23.setVisibility(View.VISIBLE);
                                           img23.setImageResource(R.drawable.disc1r);
                                           red23 = true;
                                           red33 = false;
                                           position23 = 1;
                                           position33 = 0;
                                       }
                                   }
                               } else {
                                   if (position22 == 0) {
                                       if (green33) {
                                           if (!red33&&!red32&&!red31&&!green32&&!red23) {
                                               img33.setVisibility(View.GONE);
                                               img22.setVisibility(View.VISIBLE);
                                               img22.setImageResource(R.drawable.disc2r);
                                               green22 = true;
                                               green33 = false;
                                               position22 = 1;
                                               position33 = 0;
                                           }
                                       }else {
                                           if (red33) {
                                               if(!red32&&!red31&&!red23) {
                                                   img33.setVisibility(View.GONE);
                                                   img22.setVisibility(View.VISIBLE);
                                                   img22.setImageResource(R.drawable.disc1r);
                                                   red22 = true;
                                                   red33 = false;
                                                   position22 = 1;
                                                   position33 = 0;
                                               }
                                           }
                                       }
                                   } else {
                                       if (red33) {
                                           if(!red32&&!red31&&!red23&&!red22) {
                                               img33.setVisibility(View.GONE);
                                               img21.setVisibility(View.VISIBLE);
                                               img21.setImageResource(R.drawable.disc1r);
                                               red21 = true;
                                               red33 = false;
                                               position21 = 1;
                                               position33 = 0;
                                           }
                                       }
                                   }
                               }
                           }
                       }
                    //done
                    countmovieeasy++;
                    counttext.setText(""+countmovieeasy);
                    break;
            }
            return true;
        }
    };
}