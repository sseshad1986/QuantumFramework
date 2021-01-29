package com.quantum.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.quantum.helper.BaseClass;
import com.quantum.utils.DeviceUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SuppressWarnings("static-access")
public class Nflows_Admin_Roles extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "nflows.admin.roles.newrole.button")
	private QAFExtendedWebElement NewRole;

	@FindBy(locator = "nflows.admin.roles.searchbx.txtbx")
	private QAFExtendedWebElement SearchBox;

	@FindBy(locator = "nflows.admin.roles.newrole.rolename.txtbx")
	private QAFExtendedWebElement RoleName;

	@FindBy(locator = "nflows.admin.roles.newrole.description.txtbx")
	private QAFExtendedWebElement RoleDescription;

	@FindBy(locator = "nflows.admin.roles.newrole.status.toggle")
	private QAFExtendedWebElement Status;

	@FindBy(locator = "nflows.admin.roles.newrole.save.button")
	private QAFExtendedWebElement Save;

	@FindBy(locator = "nflows.admin.roles.newrole.cancel.button")
	private QAFExtendedWebElement Cancel;

	@FindBy(locator = "nflows.admin.roles.searchresult")
	private QAFExtendedWebElement SearchResult;

	@FindBy(locator = "nflows.admin.roles.newrole.successmsg")
	private QAFExtendedWebElement SuccessMsg;

	@FindBy(locator = "nflows.admin.roles.searchresult.edit")
	private QAFExtendedWebElement SearchResultEdit;

	@FindBy(locator = "nflows.admin.roles.newrole.status.Active")
	private QAFExtendedWebElement ActiveStatus;

	@FindBy(locator = "nflows.admin.roles.newrole.status.Inactive")
	private QAFExtendedWebElement InactiveStatus;
		
	@FindBy(locator = "nflows.admin.roles.menulevel.search")
	private QAFExtendedWebElement menuLevelSearch;
	
	@FindBy(locator = "nflows.admin.roles.menulevel.Entity")
	private QAFExtendedWebElement rolesMenuLevelEntity;
	
	@FindBy(locator = "nflows.admin.roles.menulevel.workflow")
	private QAFExtendedWebElement rolesMenuLevelWorkflow;

	@FindBy(locator = "nflows.admin.roles.menulevel.request")
	private QAFExtendedWebElement rolesMenuLevelRequest;

	@FindBy(locator = "nflows.admin.roles.menulevel.task")
	private QAFExtendedWebElement rolesMenuLevelTask;

	@FindBy(locator = "nflows.admin.roles.menulevel.documentmanager")
	private QAFExtendedWebElement rolesMenuLevelDocMgr;

	@FindBy(locator = "nflows.admin.roles.menulevel.Widgets")
	private QAFExtendedWebElement rolesMenuLevelWidgets;

	@FindBy(locator = "nflows.admin.roles.menulevel.dashboard")
	private QAFExtendedWebElement rolesMenuLevelDashboard;

	@FindBy(locator = "nflows.admin.roles.menulevel.Report")
	private QAFExtendedWebElement rolesMenuLevelReports;
	
	@FindBy(locator = "nflows.admin.roles.menulevel.Administrator")
	private QAFExtendedWebElement rolesMenuLevelAdmin;
		
	@FindBy(locator = "nflows.admin.roles.menulevel.entitydef.dropdown")
	private QAFExtendedWebElement entitydefDrpdwn;
	
	@FindBy(locator = "nflows.admin.roles.menulevel.workflow.dropdown")
	private QAFExtendedWebElement rolesMenuWfDropdown;
	
	@FindBy(locator = "nflows.admin.roles.menulevel.entity.dropdown")
	private QAFExtendedWebElement rolesMenuEntityDrpDwn;

	@FindBy(locator = "nflows.admin.roles.menulevel.myReq.dropdown")
	private QAFExtendedWebElement rolesMenumyReqDrpDwn;

	@FindBy(locator = "nflows.admin.roles.menulevel.reqAdmin.dropdown")
	private QAFExtendedWebElement rolesMenuReqAdminDrpDwn;

	@FindBy(locator = "nflows.admin.roles.menulevel.task.dropdown")
	private QAFExtendedWebElement rolesMenuTaskDrpDwn;

	@FindBy(locator = "nflows.admin.roles.menulevel.docManager.dropdown")
	private QAFExtendedWebElement rolesMenuDocMgrDrpDwn;

	@FindBy(locator = "nflows.admin.roles.menulevel.widgets.dropdown")
	private QAFExtendedWebElement rolesMenuWidgetsDrpDwn;
	
	@FindBy(locator = "nflows.admin.roles.menulevel.AuditReport.dropdown")
	private QAFExtendedWebElement rolesMenuAuditRepDrpDwn;
	
	@FindBy(locator = "nflows.admin.roles.menulevel.SecurityMaster.dropdown")
	private QAFExtendedWebElement rolesMenuSecMasterDrpDwn;
	
	@FindBy(locator = "nflows.admin.roles.menulevel.APITokens.dropdown")
	private QAFExtendedWebElement rolesMenuApiTokenDrpDwn;
	
	@FindBy(locator = "nflows.admin.roles.menulevel.SysAdmin.dropdown")
	private QAFExtendedWebElement rolesMenuSysAdmDrpDwn;
	
	@FindBy(locator = "nflows.admin.roles.menulevel.TeamDef.dropdown")
	private QAFExtendedWebElement rolesMenuTeamDefDrpDwn;

	@FindBy(locator = "nflows.admin.roles.menulevel.Teams.dropdown")
	private QAFExtendedWebElement rolesMenuTeamsDrpDwn;

	@FindBy(locator = "nflows.admin.roles.menulevel.Users.dropdown")
	private QAFExtendedWebElement rolesMenuUsersDrpDwn;

	@FindBy(locator = "nflows.admin.roles.menulevel.Roles.dropdown")
	private QAFExtendedWebElement rolesMenuRolesDrpDwn;

	@FindBy(locator = "nflows.admin.roles.menulevel.Message.dropdown")
	private QAFExtendedWebElement rolesMenuMessageDrpDwn;

	@FindBy(locator = "nflows.admin.roles.menulevel.Dropdown.dropdown")
	private QAFExtendedWebElement rolesMenuDropdownDrpDwn;
	
	@FindBy(locator = "nflows.admin.roles.menulevel.ExportAPI.dropdown")
	private QAFExtendedWebElement rolesMenuExportAPIDrpDwn;
	
	@FindBy(locator = "nflows.admin.roles.menulevel.BusinessCalendar.dropdown")
	private QAFExtendedWebElement rolesMenuBusinesCalDrpDwn;
	
	@FindBy(locator = "nflows.admin.roles.menulevel.ProcessManager.dropdown")
	private QAFExtendedWebElement rolesMenuProcessMgrDrpDwn;

	@FindBy(locator = "nflows.admin.roles.menulevel.UserAccessConfig.dropdown")
	private QAFExtendedWebElement rolesMenuUserAccessconfigDrpDwn;

	@FindBy(locator = "nflows.admin.roles.menulevel.EntDataDict.dropdown")
	private QAFExtendedWebElement rolesMenuEntDataDictDrpDwn;
	
	@FindBy(locator = "nflows.admin.roles.menulevel.wfDataDict.dropdown")
	private QAFExtendedWebElement rolesMenuwfDataDictDrpDwn;
	
	@FindBy(locator = "nflows.admin.roles.menulevel.UserDef.dropdown")
	private QAFExtendedWebElement rolesMenuUserDefDrpDwn;
	
	@FindBy(locator = "nflows.admin.roles.dataAccess.button")
	private QAFExtendedWebElement rolesDataAccess;
	
	@FindBy(locator = "nflows.admin.roles.dataAccess.Search")
	private QAFExtendedWebElement rolesDataAccessSearch;
	
	@FindBy(locator = "nflows.roles.dataAccess.Read.Dropdown")
	private QAFExtendedWebElement rolesDataAccessReadDropdown;
	

	@FindBy(locator = "nflows.roles.dataAccess.rule.Search")
	private QAFExtendedWebElement rolesDataAccessruleSearch;
	
	@FindBy(locator = "nflows.roles.dataAccess.tick.button")
	private QAFExtendedWebElement rolesDataAccesstickbutton;
	
	@FindBy(locator = "nflows.roles.dataAccess.Write.Dropdown")
	private QAFExtendedWebElement rolesDataAccessWriteDropdown;

	// ------------------------------ Locator Ends here !
	// ----------------------------------------------------

	public QAFExtendedWebElement getActiveStatus() {
		return ActiveStatus;
	}

	public QAFExtendedWebElement getInactiveStatus() {
		return InactiveStatus;
	}

	public QAFExtendedWebElement getSearchResultEdit() {
		return SearchResultEdit;
	}

	public QAFExtendedWebElement getSuccessMsg() {
		return SuccessMsg;
	}

	public QAFExtendedWebElement getNewRole() {
		return NewRole;
	}

	public QAFExtendedWebElement getSearchBox() {
		return SearchBox;
	}

	public QAFExtendedWebElement getRoleName() {
		return RoleName;
	}

	public QAFExtendedWebElement getRoleDescription() {
		return RoleDescription;
	}

	public QAFExtendedWebElement getStatus() {
		return Status;
	}

	public QAFExtendedWebElement getSave() {
		return Save;
	}

	public QAFExtendedWebElement getCancel() {
		return Cancel;
	}

	public QAFExtendedWebElement getSearchResult() {
		return SearchResult;
	}
	
	public QAFExtendedWebElement getrolesMenuLevelEntity() {
		return rolesMenuLevelEntity;
	}
	
	public QAFExtendedWebElement getrolesMenuLevelWorkflow() {
		return rolesMenuLevelWorkflow;
	}

	public QAFExtendedWebElement getrolesMenuLevelRequest() {
		return rolesMenuLevelRequest;
	}

	public QAFExtendedWebElement getrolesMenuLevelTask() {
		return rolesMenuLevelTask;
	}

	public QAFExtendedWebElement getrolesMenuLevelDocMgr() {
		return rolesMenuLevelDocMgr;
	}

	public QAFExtendedWebElement getrolesMenuLevelWidgets() {
		return rolesMenuLevelWidgets;
	}

	public QAFExtendedWebElement getrolesMenuLevelDashboard() {
		return rolesMenuLevelDashboard;
	}

	public QAFExtendedWebElement getrolesMenuLevelReports() {
		return rolesMenuLevelReports;
	}
	
	public QAFExtendedWebElement getrolesMenuLevelAdmin() {
		return rolesMenuLevelAdmin;
	}
	
	public QAFExtendedWebElement getrolesMenuWfDropdown() {
		return rolesMenuWfDropdown;
	}
	
	public QAFExtendedWebElement getrolesMenuEntityDrpDwn() {
		return rolesMenuEntityDrpDwn;
	}

	public QAFExtendedWebElement getrolesMenumyReqDrpDwn() {
		return rolesMenumyReqDrpDwn;
	}

	public QAFExtendedWebElement getrolesMenuReqAdminDrpDwn() {
		return rolesMenuReqAdminDrpDwn;
	}
	
	public QAFExtendedWebElement getrolesMenuTaskDrpDwn() {
		return rolesMenuTaskDrpDwn;
	}
	
	public QAFExtendedWebElement getrolesMenuDocMgrDrpDwn() {
		return rolesMenuDocMgrDrpDwn;
	}

	public QAFExtendedWebElement getrolesMenuWidgetsDrpDwn() {
		return rolesMenuWidgetsDrpDwn;
	}

	public QAFExtendedWebElement getrolesMenuAuditRepDrpDwn() {
		return rolesMenuAuditRepDrpDwn;
	}

	public QAFExtendedWebElement getrolesMenuSecMasterDrpDwn() {
		return rolesMenuSecMasterDrpDwn;
	}

	public QAFExtendedWebElement getrolesMenuApiTokenDrpDwn() {
		return  rolesMenuApiTokenDrpDwn;
	}

	public QAFExtendedWebElement getrolesMenuSysAdmDrpDwn() {
		return rolesMenuSysAdmDrpDwn;
	}

	public QAFExtendedWebElement getrolesMenuTeamDefDrpDwn() {
		return rolesMenuTeamDefDrpDwn;
	}
	
	public QAFExtendedWebElement getrolesMenuTeamsDrpDwn() {
		return rolesMenuTeamsDrpDwn;
	}
	
	public QAFExtendedWebElement getrolesMenuUsersDrpDwn() {
		return rolesMenuUsersDrpDwn;
	}
	
	public QAFExtendedWebElement getrolesrolesMenuRolesDrpDwn() {
		return rolesMenuRolesDrpDwn;
	}

	public QAFExtendedWebElement getrolesMenuMessageDrpDwn() {
		return  rolesMenuMessageDrpDwn;
	}

	public QAFExtendedWebElement getrolesMenuDropdownDrpDwn() {
		return rolesMenuDropdownDrpDwn;
	}

	public QAFExtendedWebElement getrolesMenuExportAPIDrpDwn() {
		return rolesMenuExportAPIDrpDwn;
	}
	
	public QAFExtendedWebElement getrolesMenuBusinesCalDrpDwn() {
		return rolesMenuBusinesCalDrpDwn;
	}
	
	public QAFExtendedWebElement getrolesMenuProcessMgrDrpDwn() {
		return rolesMenuProcessMgrDrpDwn;
	}
	
	public QAFExtendedWebElement getrolesMenuUserAccessconfigDrpDwn() {
		return rolesMenuUserAccessconfigDrpDwn;
	}

	public QAFExtendedWebElement getrolesMenuEntDataDictDrpDwn() {
		return rolesMenuEntDataDictDrpDwn;
	}
	
	public QAFExtendedWebElement getrolesMenuwfDataDictDrpDwn() {
		return rolesMenuwfDataDictDrpDwn;
	}
	
	public QAFExtendedWebElement getrolesMenuUserDefDrpDwn() {
		return rolesMenuUserDefDrpDwn;
	}
	
	public QAFExtendedWebElement getmenuLevelSearch() {
		return menuLevelSearch;
	}
	
	public QAFExtendedWebElement getentitydefDrpdwn() {
		return entitydefDrpdwn;
	}
	
	public QAFExtendedWebElement getrolesDataAccess() {
		return rolesDataAccess;
	}
	
	public QAFExtendedWebElement getrolesDataAccessSearch() {
		return rolesDataAccessSearch;
	}
	
	public QAFExtendedWebElement getrolesDataAccessReadDropdown() {
		return rolesDataAccessReadDropdown;
	}
	
	public QAFExtendedWebElement getrolesDataAccessruleSearch() {
		return rolesDataAccessruleSearch;
	}
	
	public QAFExtendedWebElement getrolesDataAccesstickbutton() {
		return rolesDataAccesstickbutton;
	}
	;
	public QAFExtendedWebElement getrolesDataAccessWriteDropdown() {
		return rolesDataAccessWriteDropdown;
	}

	
	// ------------------------------ Getter method Ends here !
	// ----------------------------------------------------

	// Method Author : Vasanth S
	public Boolean create_new_role_and_verify(String RoleName, String Description)
			throws InterruptedException, IOException {
		// Navigate to New Role Page and Create a Role
		Boolean IsCreated;
		String SearchResult;
		getNewRole().click();
		getSave().waitForVisible(10000);
		Thread.sleep(3000);
		CommonBean.lbase_baseClass.writeText(getRoleName(), RoleName);
		CommonBean.lbase_baseClass.writeText(getRoleDescription(), Description);
		Thread.sleep(500);
		BaseClass.getScreenshot("Create new Role with RoleName : " + RoleName);
		CommonBean.lbase_baseClass.clickButton(getSave());
		;
		getSuccessMsg().waitForVisible(10000);
		BaseClass.getScreenshot("Role saved successfully : " + RoleName);
		Thread.sleep(5000);
		CommonBean.lbase_baseClass.waitForVisibility(getRoleName());
		// getRoleName().waitForVisible(10000);

		// Go Back to Roles Landing Page and Verify
		getCancel().click();
		getNewRole().waitForVisible(10000);
		CommonBean.lbase_baseClass.writeText(getSearchBox(), RoleName);
		getSearchBox().sendKeys(Keys.RETURN);
		Thread.sleep(500);
		SearchResult = CommonBean.lbase_baseClass.getText(getSearchResult());
		if (SearchResult.equals(RoleName)) {
			BaseClass.getScreenshot("Create New Role Verified");
			IsCreated = true;
		} else {
			IsCreated = false;
		}
		Thread.sleep(1000);
		getSearchBox().clear();
		return IsCreated;
	}

	// Method Author : Vasanth S
	public Boolean edit_role_verify(String RoleName, String NewRoleName, String NewDescription)
			throws InterruptedException, IOException, NullPointerException {
		// Edit the Role
		Boolean result;
		Edit_a_Role(RoleName, NewRoleName, NewDescription, "Edit");

		// Verify the Edit
		Thread.sleep(500);
		CommonBean.lbase_baseClass.writeText(getSearchBox(), NewRoleName);
		getSearchBox().sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		if (driver.findElements(By.xpath("(//span[contains(text(),'" + NewRoleName + "')])")).size() > 0) {
			BaseClass.getScreenshot("Edit Role is verified ");
			result = true;
		} else {
			result = false;
		}
		getSearchBox().clear();
		Thread.sleep(1000);

		// Revert the edit
		Edit_a_Role(NewRoleName, RoleName, NewDescription, "Revert");
		return result;
	}

	// Method Author : Vasanth S
	public void Edit_a_Role(String RoleName, String NewRoleName, String NewDescription, String EditType)
			throws InterruptedException, IOException, NullPointerException {
		// Search the Role to Edit
		CommonBean.lbase_baseClass.writeText(getSearchBox(), RoleName);
		getSearchBox().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		getSearchResultEdit().click();
		CommonBean.lbase_baseClass.waitBeforeClick(getSave());
		Thread.sleep(5000);

		// Inside Role Details Page and Edit the role
		getRoleName().clear();
		getRoleDescription().clear();
		Thread.sleep(500);
		CommonBean.lbase_baseClass.writeText(getRoleName(), NewRoleName);
		Thread.sleep(500);
		CommonBean.lbase_baseClass.writeText(getRoleDescription(), NewDescription);
		Thread.sleep(500);
		if (EditType.equals("Edit"))
			BaseClass.getScreenshot("Edit existing role with : " + NewRoleName);
		CommonBean.lbase_baseClass.clickButton(getSave());
		;
		getSuccessMsg().waitForVisible(20000);
		Thread.sleep(6000);
		getRoleName().waitForVisible(10000);
		Thread.sleep(3000);

		// Go Back to Roles Landing Page and Verify Edit
		getCancel().click();
		getNewRole().waitForVisible(10000);
		Thread.sleep(4000);
	}

	// Method Author : Vasanth S
	public Boolean search_roles_and_verify(String RoleName) throws InterruptedException, IOException {
		// Search the Role to Edit
		Boolean result;
		CommonBean.lbase_baseClass.writeText(getSearchBox(), RoleName);
		getSearchBox().sendKeys(Keys.ENTER);
		BaseClass.getScreenshot("Roles landing page search is verified ");
		Thread.sleep(500);
		if (driver.findElements(By.xpath("(//span[contains(text(),'" + RoleName + "')])")).size() > 0) {
			result = true;
		} else {
			result = false;
		}
		//getSearchBox().clear();
		Thread.sleep(1000);
		return result;
	}

	// Method Author : Vasanth S
	public Boolean inactive_roles_and_verify(String RoleName) throws InterruptedException, IOException {
		Boolean result;
		Inactive_Toggle_a_Role(RoleName, "Edit");

		// Verify the Inactive State
		Thread.sleep(500);
		CommonBean.lbase_baseClass.writeText(getSearchBox(), RoleName);
		getSearchBox().sendKeys(Keys.ENTER);
		BaseClass.getScreenshot("Inactive a Role is verified : " + RoleName);
		Thread.sleep(4000);
		if (driver.findElements(By.xpath("(//span[contains(text(),'Inactive')])")).size() > 0) {
			result = true;
		} else {
			result = false;
		}
		getSearchBox().clear();

		// Revert the Inactive State
		Inactive_Toggle_a_Role(RoleName, "Revert");
		return result;
	}

	public void Inactive_Toggle_a_Role(String RoleName, String EditType) throws InterruptedException, IOException {
		// Search the Role to Edit
		CommonBean.lbase_baseClass.writeText(getSearchBox(), RoleName);
		getSearchBox().sendKeys(Keys.ENTER);
		Thread.sleep(500);
		getSearchResultEdit().click();
		CommonBean.lbase_baseClass.waitBeforeClick(getSave());
		Thread.sleep(4000);

		// Inside Role Details Page
		getActiveStatus().click();
		Thread.sleep(500);
		if (EditType.equals("Edit"))
			BaseClass.getScreenshot("Existing Role is made inactive" + RoleName);
		CommonBean.lbase_baseClass.clickButton(getSave());
		;
		getSuccessMsg().waitForVisible(20000);
		Thread.sleep(6000);
		getRoleName().waitForVisible(10000);
		Thread.sleep(3000);

		// Go Back to Roles Landing Page
		getCancel().click();
		CommonBean.lbase_baseClass.waitBeforeClick(getNewRole());
		Thread.sleep(4000);
	}
	
	// Method Author : Sundar
	public Boolean search_roles_and_edit(String RoleName) throws InterruptedException, IOException {
		// Search the Role to Edit
		Boolean result;
		CommonBean.lbase_baseClass.writeText(getSearchBox(), RoleName);
		getSearchBox().sendKeys(Keys.ENTER);
		BaseClass.getScreenshot("Roles landing page search is verified ");
		Thread.sleep(500);
		if (driver.findElements(By.xpath("(//span[contains(text(),'" + RoleName + "')])")).size() > 0) {
			getSearchResultEdit().click();
			Thread.sleep(10000);

		} else {
			result = false;
		}
		// getSearchBox().clear();
		Thread.sleep(2000);
		result = true;
		BaseClass.getScreenshot("Roles edit search is verified ");
		return result;
	}
		
	
	// Method Author : Sundar
	public void menuLevelAccess(String access) throws InterruptedException, IOException {

		
		getmenuLevelSearch().sendKeys("Entity Definition");
		getmenuLevelSearch().sendKeys(Keys.ENTER);
		Thread.sleep(500);
		CommonBean.lbase_baseClass.selectByValue(getentitydefDrpdwn(), access);
		getmenuLevelSearch().clear();
		getrolesMenuLevelEntity().click();
		Thread.sleep(500);

		getrolesMenuLevelWorkflow().click();
		CommonBean.lbase_baseClass.selectByValue(getrolesMenuWfDropdown(), access);
		getrolesMenuLevelWorkflow().click();
		Thread.sleep(500);

		getrolesMenuLevelRequest().click();
		CommonBean.lbase_baseClass.selectByValue(getrolesMenumyReqDrpDwn(), access);
		CommonBean.lbase_baseClass.selectByValue(getrolesMenuReqAdminDrpDwn(), access);
		BaseClass.getScreenshot("Roles access is changed to -" + " " + access);
		getrolesMenuLevelRequest().click();

		Thread.sleep(500);

		if (!access.contains("READ")) {
			getrolesMenuLevelTask().click();
			CommonBean.lbase_baseClass.selectByValue(getrolesMenuTaskDrpDwn(), access);
			getrolesMenuLevelTask().click();
			BaseClass.getScreenshot("Roles access is changed to -" + " " + access);
			Thread.sleep(500);
		}

		if (!access.contains("WRITE")) {
			getrolesMenuLevelDocMgr().click();
			CommonBean.lbase_baseClass.selectByValue(getrolesMenuDocMgrDrpDwn(), access);
			BaseClass.getScreenshot("Roles access is changed to -" + " " + access);
			getrolesMenuLevelDocMgr().click();
			Thread.sleep(500);
		}

		/*getrolesMenuLevelWidgets().click();
		if (!getrolesMenuWidgetsDrpDwn().isDisplayed()) {
			getrolesMenuLevelWidgets().click();
		}
		CommonBean.lbase_baseClass.selectByValue(getrolesMenuWidgetsDrpDwn(), access);
		getrolesMenuLevelWidgets().click();
		Thread.sleep(500);*/

		getrolesMenuLevelAdmin().click();
		if (!access.contains("WRITE")) {
			CommonBean.lbase_baseClass.selectByValue(getrolesMenuAuditRepDrpDwn(), access);
			Thread.sleep(100);
			BaseClass.getScreenshot("Roles access is changed to -" + " " + access);
		}

		CommonBean.lbase_baseClass.selectByValue(getrolesMenuSecMasterDrpDwn(), access);
		CommonBean.lbase_baseClass.selectByValue(getrolesMenuApiTokenDrpDwn(), access);
		if (!access.contains("WRITE")) {
			CommonBean.lbase_baseClass.selectByValue(getrolesMenuSysAdmDrpDwn(), access);
			Thread.sleep(1000);
			BaseClass.getScreenshot("Roles access is changed to -" + " " + access);
		}
		
		CommonBean.lbase_baseClass.selectByValue(getrolesMenuExportAPIDrpDwn(), access);
		CommonBean.lbase_baseClass.selectByValue(getrolesMenuTeamDefDrpDwn(), access);
		CommonBean.lbase_baseClass.selectByValue(getrolesMenuTeamsDrpDwn(), access);
		CommonBean.lbase_baseClass.selectByValue(getrolesMenuUsersDrpDwn(), access);
		CommonBean.lbase_baseClass.selectByValue(getrolesMenuMessageDrpDwn(), access);
		CommonBean.lbase_baseClass.selectByValue(getrolesMenuDropdownDrpDwn(), access);
		
		CommonBean.lbase_baseClass.selectByValue(getrolesMenuBusinesCalDrpDwn(), access);
		CommonBean.lbase_baseClass.selectByValue(getrolesMenuProcessMgrDrpDwn(), access);
		CommonBean.lbase_baseClass.selectByValue(getrolesMenuUserAccessconfigDrpDwn(), access);
		CommonBean.lbase_baseClass.selectByValue(getrolesMenuEntDataDictDrpDwn(), access);
		CommonBean.lbase_baseClass.selectByValue(getrolesMenuwfDataDictDrpDwn(), access);
		//CommonBean.lbase_baseClass.selectByValue(getrolesMenuUserDefDrpDwn(), access);
		BaseClass.getScreenshot("Roles Admin access is changed to " + " " + access);
		getrolesMenuLevelAdmin().click();
		CommonBean.lbase_baseClass.clickButton(getSave());
		getSuccessMsg().waitForVisible(20000);
		Thread.sleep(6000);
		getRoleName().waitForVisible(10000);
		Thread.sleep(3000);

		// Go Back to Roles Landing Page and Verify Edit
		getCancel().click();
		getNewRole().waitForVisible(10000);
		Thread.sleep(4000);
	}	

	public boolean validate_Access_menu(String menuName, String landingmenu) throws Throwable {

		boolean isMenuPresent = false;
		boolean Display = false;

		String[] menu = menuName.split(";");
		String[] defMenu = landingmenu.split(";");
		for (int i = 0; i < menu.length; i++) {
			isMenuPresent = CommonBean.lHome_page_home.navigateByMenu(menu[i]);

			if (isMenuPresent) {

				if (defMenu[i].equals("NA")) {
					System.out.println("Menu level validation successfull at" + " " + menu[i]);
					Reporter.log("Menu level validation successfull - Pass" + menu[i]);
					BaseClass.getScreenshot("Menu level validation successfull at" + " " + menu[i]);
				} else {
					Display = CommonBean.lHome_page_home.getvalidateButton(defMenu[i]).isDisplayed();
					System.out.println("Menu level validation successfull at" + " " + menu[i]);
					Reporter.log("Menu level validation successfull at" + " " + menu[i]);
					BaseClass.getScreenshot("Menu level validation successfull at" + " " + menu[i]);

				}
			} else {
				System.out.println("Menu level validation successfull at" + " " + menu[i]);
				Reporter.log("Menu level validation successfull at" + " " + menu[i]);

			}

		}
		return Display;
	}

	public void roles_menuAccess(String entity) throws Throwable {
		CommonBean.roles.getrolesDataAccess().waitForVisible(4000);
		if (getrolesDataAccess().isDisplayed()) {
			getrolesDataAccess().click();
			CommonBean.roles.getrolesDataAccessSearch().waitForVisible(2000);
			CommonBean.lbase_baseClass.writeText(getrolesDataAccessSearch(), entity);
			

		}
	}

	public void unselectRules(String rules) throws Throwable {
		CommonBean.lbase_baseClass.unselectFromDropdownList(getrolesDataAccessReadDropdown(), rules);
		CommonBean.lbase_baseClass.unselectFromDropdownList(getrolesDataAccessWriteDropdown(), rules);
		Reporter.log("Unselected the rules from dropdown" + " " + rules);
		CommonBean.lbase_baseClass.clickButton(getSave());
		getSuccessMsg().waitForVisible(20000);
		Thread.sleep(6000);
		getRoleName().waitForVisible(10000);
		Thread.sleep(3000);
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}

}
