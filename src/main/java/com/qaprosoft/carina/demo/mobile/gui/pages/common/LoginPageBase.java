package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class LoginPageBase extends AbstractPage {

	public LoginPageBase(WebDriver driver) {
		super(driver);
	}

	public abstract void typeName(String name);

	public abstract void typePassword(String password);

	public abstract void selectMaleSex();

	public abstract void checkPrivacyPolicyCheckbox();

	public abstract CarinaDescriptionPageBase clickLoginBtn();

	public abstract boolean isLoginBtnActive();

	public abstract boolean isNameFieldPresented();

	public abstract  boolean isPasswordFieldPresented();

	public abstract  boolean isMaleSexRadioButtonPresented();

	public abstract  boolean isFemaleSexRadioButtonPresented();

	public abstract boolean isPrivacyPolicyCheckboxPresented();

	public abstract boolean isSexMaleChecked();

	public abstract boolean isSexFemaleChecked();

	public abstract boolean isPrivacyPolicyCheckboxChecked();

	public abstract CarinaDescriptionPageBase login();

}
