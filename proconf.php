#!/usr/bin/php -q
<?php
/* file: proconf.php
 * author: M. Fauzilkamil Zainuddin
 * purpose: reading a2billing 1.3.3 config file to get agi-conf and put it to database for
 *          a2billing 1.6.0
 */

include("lib/Class.A2bConf.php");

echo "++ A2billing ProConf v0.1 ++\n";
echo "++ ProConf : Process A2Billing Conf File ++\n";
echo "+ Reading config file +\n";

/* create the conf object */
$a2b = new A2bcfg();

/* load a2billing.conf v1.3.3 */
$a2b->load_config("data/a2billing.conf");
//echo print_r($a2b->config,true);

// get default values for each agi-conf
$dbagi = $a2b->getDBagi();

for ($i = 2; $i < 12; $i++) {

	$agiconf = "agi-conf" . $i;

	echo "+ Reading " . $agiconf . " +\n";

	/* create default AGI based on agi-conf1 */
	$a2b->CreateDefaultAGI($i,$dbagi);
	
	echo "  ---------------\n";
	sleep(1);

	$a2b->CopyConfToDB($i, $dbagi, $a2b->config[$agiconf]);
	
	echo "    ---------------\n";

	if (!$a2b->CheckAGIGroupExists($agiconf)) {
		echo "insert agi group: $agiconf\n";
		$confdesc = "This configuration group handles the AGI Configuration.";
		$a2b->insertAGIGroup($agiconf,$confdesc);
	}
	
	echo "---------------\n";
	sleep(1);
}

echo "\n\n+ Process End +\n";
?>
