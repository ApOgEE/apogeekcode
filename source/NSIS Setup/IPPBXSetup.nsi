; PersiaSYS IPPBX Status installer
; Author: M. Fauzilkamil Zainuddin <jerungkun@gmail.com>
; Since: 2011/04/12
; Copyright (C) 2009 M. Fauzilkamil Zainuddin

; defines
!define PRODUCT_NAME "IPPBX Status"
!define PRODUCT_VERSION "0.0.3"
!define PRODUCT_PUBLISHER "Persiasys Sdn. Bhd."
!define PRODUCT_WEB_SITE "http://www.persiasys.com"
!define APPMAIN_SOURCE_DIR "..\IPPBX Status\dist"
!define APPTOOL_SOURCE_DIR "..\ippbx-tools\dist"
!define APPSUPPORT_SOURCE_DIR "..\support"

; installer name
Name "IPPBX Status Setup"
Caption "IPPBX Status Setup"
; Icon "ippbxsetup.ico"
OutFile "IPPBX Status Setup.exe"

;RequestExecutionLevel user

; define installation directory
InstallDir "$PROGRAMFILES\IPPBX Status"

; default installer section start
Section
    ;SetShellVarContext all
	
    ; set the installation directory as the destination for the following actions
    SetOutPath $INSTDIR
	SetOverwrite ifnewer

	# read the value from the registry into the $0 register
    ReadRegStr $0 HKLM "SOFTWARE\JavaSoft\Java Runtime Environment" CurrentVersion
 
    # print the results in a popup message box
    MessageBox MB_OK "Java Runtime Environment Version: $0"

	
	File "${APPMAIN_SOURCE_DIR}\IPPBX Status.jar"
	File "${APPTOOL_SOURCE_DIR}\ippbx-tools.jar"
	File "${APPSUPPORT_SOURCE_DIR}\logoutippbx.bat"
 
 
    # create a shortcut named "new shortcut" in the start menu programs directory
    # point the new shortcut at the program uninstaller
    CreateShortCut "$SMPROGRAMS\IPPBX Status\IPPBX Status.lnk" "$INSTDIR\IPPBX Status.jar"
    CreateShortCut "$SMPROGRAMS\IPPBX Status\Uninstall IPPBX Status.lnk" "$INSTDIR\uninstall.exe"

	# create the uninstaller
    WriteUninstaller "$INSTDIR\uninstall.exe"


# default installer section end
SectionEnd

# ---------- Uninstaller Section ---------
Section "uninstall"
    ;SetShellVarContext all

	# remove the link from the start menu
    Delete "$SMPROGRAMS\IPPBX Status\IPPBX Status.lnk"
    Delete "$SMPROGRAMS\IPPBX Status\Uninstall IPPBX Status.lnk"

    # delete the uninstaller
    Delete "$INSTDIR\uninstall.exe"
	
	Delete "$INSTDIR\IPPBX Status.jar"
	Delete "$INSTDIR\ippbx-tools.jar"
	Delete "$INSTDIR\logoutippbx.bat"
	Delete "$INSTDIR\ippbxstatus.conf"
	
	RMDir "$INSTDIR"
	RMDir "$SMPROGRAMS\IPPBX Status"
	
	# message for uninstall
	;MessageBox MB_OK "Uninstall Finished"
	;SetAutoClose true
	
# end section uninstall
SectionEnd