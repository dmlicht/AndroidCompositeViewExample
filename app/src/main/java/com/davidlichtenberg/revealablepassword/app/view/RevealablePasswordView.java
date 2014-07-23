package com.davidlichtenberg.revealablepassword.app.view;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.davidlichtenberg.revealablepassword.app.R;

public class RevealablePasswordView extends RelativeLayout {
  @InjectView(R.id.password) EditText password;
  @InjectView(R.id.display_button) Button displayButton;

  private boolean revealed;

  @OnClick(R.id.display_button)
  public void togglePasswordVisibility() {
    if (revealed) {
      hide();
    } else {
      reveal();
    }
  }

  private void hide() {
    displayButton.setText("SHOW");
    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    revealed = false;
  }

  private void reveal() {
    displayButton.setText("HIDE");
    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
    revealed = true;
  }

  private void init(Context context) {
    if (isInEditMode()) {return;} // Intellij will complain about your custom views

    revealed = false;

    inflate(context, R.layout.revealable_password_view, this);
    ButterKnife.inject(this);
  }

  public RevealablePasswordView(Context context) {
    super(context);
    init(context);
  }


  public RevealablePasswordView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  public RevealablePasswordView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    init(context);
  }
}
