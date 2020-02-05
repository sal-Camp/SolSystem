package data.scripts;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.*;
import com.fs.starfarer.api.impl.campaign.econ.AbandonedStation;
import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.impl.campaign.ids.Terrain;
import com.fs.starfarer.combat.entities.terrain.Planet;

import java.awt.*;

public class SolSystem_modPlugin extends BaseModPlugin {
    @Override
    public void onNewGame() {

    	//Change this to false to turn off preset conditions and allow random conditions for all the planets.
    	boolean presetConditions = true;

		SectorAPI sector = Global.getSector();
		StarSystemAPI system = sector.createStarSystem("Sol");

		//Star
		PlanetAPI star = system.initStar(
			"sol",
			"star_yellow",
			1000,
			8500,
			-10500,
			500);

		////////////////////////
		// Structure Entities //
		////////////////////////

		//Buoy
		SectorEntityToken buoy = system.addCustomEntity("sol_buoy",
				 "Sol Buoy",
				 "nav_buoy",
				 "neutral");
		buoy.setCircularOrbitPointingDown(star, 40, 7000, 400);

		//Relay
		SectorEntityToken relay = system.addCustomEntity("sol_relay",
				 "Sol Relay",
				 "comm_relay",
				 "neutral");
		relay.setCircularOrbitPointingDown(star, 190, 7000, 400);

		//Array
		SectorEntityToken array = system.addCustomEntity("sol_array",
				 "Sol Array",
				 "sensor_array",
				 "neutral");
		array.setCircularOrbitPointingDown(star, 280, 7000, 400);

		//Gate
		SectorEntityToken sol_gate = system.addCustomEntity("sol_gate",
				 "Sol Gate",
				 "inactive_gate",
				 null);
		sol_gate.setCircularOrbit(star, 120, 7000, 400);

		////////////////////////////////
		// Planet & Entity Generation //
		////////////////////////////////

		// Mercury
		PlanetAPI mercury = system.addPlanet("mercury", star, "Mercury", "barren-bombarded", 0, 60, 1500, 88);
		mercury.getSpec().setTexture(Global.getSettings().getSpriteName("planets", "ssmod_mercury"));
		mercury.applySpecChanges();

		// Venus
		PlanetAPI venus = system.addPlanet("venus", star, "Venus", "toxic", 0, 140, 2200, 225);
		venus.getSpec().setTexture(Global.getSettings().getSpriteName("planets", "ssmod_venus"));
		venus.applySpecChanges();

		// Terra
		PlanetAPI terra = system.addPlanet("terra", star, "Terra", "terran", 0, 180, 3400, 365);
		terra.getSpec().setTexture(Global.getSettings().getSpriteName("planets", "ssmod_terra"));
		//terra.getSpec().setCloudTexture(Global.getSettings().getSpriteName("planets", "ssmod_terra_clouds"));
		//terra.getSpec().setCloudColor([235,240,250,225]);
		terra.applySpecChanges();

			// Luna
			PlanetAPI luna = system.addPlanet("luna", terra, "Luna","barren-bombarded", 0,40, 350, 30);
			luna.getSpec().setTexture(Global.getSettings().getSpriteName("moons", "ssmod_luna"));
			luna.applySpecChanges();

		// Mars
		PlanetAPI mars = system.addPlanet("mars", star, "Mars", "desert", 0, 80, 5000, 500);
		mars.getSpec().setTexture(Global.getSettings().getSpriteName("planets", "ssmod_mars"));
		mars.applySpecChanges();

		// Asteroid Belt
		system.addAsteroidBelt(star, 750, 6000, 500, 700, 300, Terrain.ASTEROID_BELT, "Asteroid Belt");
		system.addRingBand(star, "misc", "rings_asteroids0", 256f, 4, Color.white,256f,6000,295f,Terrain.ASTEROID_BELT,"Asteroid Belt1");

		// Ceres
		PlanetAPI ceres = system.addPlanet("ceres", star, "Ceres", "barren", 0,10, 6000, 700);
		ceres.getSpec().setTexture(Global.getSettings().getSpriteName("planets", "ssmod_ceres"));
		ceres.applySpecChanges();

		// Asteroid Belt Jump Point
		JumpPointAPI asteroid_belt_jump_point = Global.getFactory().createJumpPoint("sol_jump1", "Sol Jump-Point1");
		asteroid_belt_jump_point.setCircularOrbit(system.getEntityById("sol"), 245, 7000, 200);
		asteroid_belt_jump_point.setStandardWormholeToHyperspaceVisual();
		system.addEntity(asteroid_belt_jump_point);

		// Jupiter
		PlanetAPI jupiter = system.addPlanet("jupiter", star, "Jupiter", "gas_giant", 30, 500, 8800, 800);
		jupiter.getSpec().setTexture(Global.getSettings().getSpriteName("planets", "ssmod_jupiter"));
		jupiter.applySpecChanges();

			// Io
			PlanetAPI io = system.addPlanet("io", jupiter, "Io", "lava_minor", 120,50, 800, 45);
			io.getSpec().setTexture(Global.getSettings().getSpriteName("moons", "ssmod_io"));
			io.applySpecChanges();

			// Europa
			PlanetAPI europa = system.addPlanet("europa", jupiter, "Europa", "frozen", 0, 40, 1125, 30);
			europa.getSpec().setTexture(Global.getSettings().getSpriteName("moons", "ssmod_europa"));
			europa.applySpecChanges();

			// Ganymede
			PlanetAPI ganymede = system.addPlanet("ganymede", jupiter, "Ganymede", "rocky_ice", 240, 70, 1400, 60);
			ganymede.getSpec().setTexture(Global.getSettings().getSpriteName("moons", "ssmod_ganymede"));
			ganymede.applySpecChanges();

			// Callisto
			PlanetAPI callisto = system.addPlanet("callisto", jupiter, "Callisto", "barren-bombarded", 160, 55, 1800, 75);
			callisto.getSpec().setTexture(Global.getSettings().getSpriteName("moons", "ssmod_callisto"));
			callisto.applySpecChanges();

			// Jupiter's Belt
			//system.addRingBand(jupiter, "misc", "rings_ice0", 256f, 2, Color.white, 256f, 800, 45, Terrain.RING, "Jupiter's Belt");

		// Saturn
		PlanetAPI saturn = system.addPlanet("saturn", star, "Saturn", "gas_giant", 180, 425, 13000, 1200);
		saturn.getSpec().setTexture(Global.getSettings().getSpriteName("planets", "ssmod_saturn"));
		saturn.applySpecChanges();

			// Saturn's Belt
			system.addRingBand(saturn, "belts", "ssmod_saturn_belt", 1024, 0, Color.white, 1024, 1000, 45, Terrain.RING, "Saturn's Belt");


			// Enceladus
			PlanetAPI enceladus = system.addPlanet("enceladus", saturn, "Enceladus", "cryovolcanic", 180, 10, 1550, 30);
			enceladus.getSpec().setTexture(Global.getSettings().getSpriteName("moons", "ssmod_enceladus"));
			enceladus.applySpecChanges();

			// Titan
			PlanetAPI titan = system.addPlanet("titan", saturn, "Titan", "rocky_ice", 0, 55, 2000, 60);
			titan.getSpec().setTexture(Global.getSettings().getSpriteName("moons", "ssmod_titan"));
			titan.applySpecChanges();

		// Giants Jump Point
		JumpPointAPI giants_jump_point = Global.getFactory().createJumpPoint("sol_jump2", "Sol Jump-Point2");
		giants_jump_point.setCircularOrbit(system.getEntityById("sol"), 60, 15000, 180);
		giants_jump_point.setStandardWormholeToHyperspaceVisual();
		system.addEntity(giants_jump_point);

		// Uranus
		PlanetAPI uranus = system.addPlanet("uranus", star, "Uranus", "ice_giant", 90, 350, 17000, 1500);
		uranus.getSpec().setTexture(Global.getSettings().getSpriteName("planets", "ssmod_uranus"));
		uranus.applySpecChanges();

			// Oberon
			PlanetAPI oberon = system.addPlanet("oberon", uranus, "Oberon", "rocky_ice", 0, 40, 900, 60);
			//oberon.getSpec().setTexture(Global.getSettings().getSpriteName("moons", "ssmod_oberon"));
			//oberon.applySpecChanges();

			// Uranus' Belt
			//system.addRingBand(uranus, "misc", "rings_ice0", 256f, 2, Color.white, 256f, 550, 45, Terrain.RING, "Uranus' Belt");

		// Neptune
		PlanetAPI neptune = system.addPlanet("neptune", star, "Neptune", "ice_giant", 270, 340, 21000, 1800);
		neptune.getSpec().setTexture(Global.getSettings().getSpriteName("planets", "ssmod_neptune"));
		neptune.applySpecChanges();

			// Triton
			PlanetAPI triton = system.addPlanet("triton", neptune, "Triton", "cryovolcanic", 0, 50, 900, 60);
			//triton.getSpec().setTexture(Global.getSettings().getSpriteName("moons", "ssmod_triton"));
			//triton.applySpecChanges();

			// Neptune's Belt
			//system.addRingBand(neptune, "misc", "rings_ice0", 256f, 2, Color.white, 256f, 500, 45, Terrain.RING, "Neptune's Belt");

		// Kuiper Belt
		system.addAsteroidBelt(star, 1000, 23000, 1000, 150, 300, Terrain.ASTEROID_BELT, "Kuiper Belt");
		system.addRingBand(star, "misc", "rings_dust0", 256f, 3, Color.white, 256f, 23000, 305f, Terrain.ASTEROID_BELT,"Kuiper Belt1");
		system.addRingBand(star, "misc", "rings_asteroids0", 256f, 3, Color.white,256f,23000,295f,Terrain.ASTEROID_BELT,"Kuiper Belt2");

		// Pluto
		PlanetAPI pluto = system.addPlanet("pluto", star, "Pluto", "barren", 0, 20, 24500, 2000);
		pluto.getSpec().setTexture(Global.getSettings().getSpriteName("planets", "ssmod_pluto"));
		pluto.applySpecChanges();

			// Charon
			PlanetAPI charon = system.addPlanet("charon", pluto, "Charon", "barren", 0, 14, 100, 30);
			charon.getSpec().setTexture(Global.getSettings().getSpriteName("moons", "ssmod_charon"));
			charon.applySpecChanges();

		system.autogenerateHyperspaceJumpPoints(true,true);

		/////////////////////////////////////
		// Preset Planet & Moon Conditions //
		/////////////////////////////////////

		if (presetConditions) {
			// Mercury Conditions - 250 Hazard Rating
			MarketAPI mercury_market = Global.getFactory().createMarket("mercury_market", mercury.getName(), 0);
			mercury_market.setPlanetConditionMarketOnly(true);
			mercury_market.addCondition(Conditions.HOT);
			mercury_market.addCondition(Conditions.IRRADIATED);
			mercury_market.addCondition(Conditions.THIN_ATMOSPHERE);
			mercury_market.addCondition(Conditions.TOXIC_ATMOSPHERE);
			mercury_market.addCondition(Conditions.LOW_GRAVITY);
			mercury_market.addCondition(Conditions.ORE_ULTRARICH);
			mercury_market.addCondition(Conditions.RARE_ORE_ULTRARICH);
			mercury_market.setPrimaryEntity(mercury);
			mercury.setMarket(mercury_market);

			// Venus Conditions - 250 Hazard Rating
			MarketAPI venus_market = Global.getFactory().createMarket("venus_market", venus.getName(), 0);
			venus_market.setPlanetConditionMarketOnly(true);
			venus_market.addCondition(Conditions.VERY_HOT);
			venus_market.addCondition(Conditions.IRRADIATED);
			venus_market.addCondition(Conditions.TECTONIC_ACTIVITY);
			venus_market.addCondition(Conditions.DENSE_ATMOSPHERE);
			venus_market.addCondition(Conditions.ORE_ULTRARICH);
			venus_market.addCondition(Conditions.RARE_ORE_ULTRARICH);
			venus_market.setPrimaryEntity(venus);
			venus.setMarket(venus_market);

			// Terra Conditions - 75 Hazard Rating
			MarketAPI terra_market = Global.getFactory().createMarket("terra_market", terra.getName(), 0);
			terra_market.setPlanetConditionMarketOnly(true);
			terra_market.addCondition(Conditions.HABITABLE);
			terra_market.addCondition(Conditions.MILD_CLIMATE);
			terra_market.addCondition(Conditions.FARMLAND_BOUNTIFUL);
			terra_market.addCondition(Conditions.ORE_SPARSE);
			terra_market.addCondition(Conditions.RARE_ORE_SPARSE);
			terra_market.addCondition(Conditions.RUINS_VAST);
			terra_market.addCondition(Conditions.ORGANICS_PLENTIFUL);
			terra_market.addCondition(Conditions.DECIVILIZED);
			terra_market.setPrimaryEntity(terra);
			terra.setMarket(terra_market);

				// Luna Conditions 175 Hazard Rating
				MarketAPI luna_market = Global.getFactory().createMarket("luna_market", luna.getName(), 0);
				luna_market.setPlanetConditionMarketOnly(true);
				luna_market.addCondition(Conditions.NO_ATMOSPHERE);
				luna_market.addCondition(Conditions.LOW_GRAVITY);
				luna_market.setPrimaryEntity(luna);
				luna.setMarket(luna_market);

			// Mars Conditions 125 Hazard Rating
			MarketAPI  mars_market = Global.getFactory().createMarket("mars_market", mars.getName(), 0);
			mars_market.setPlanetConditionMarketOnly(true);
			mars_market.addCondition(Conditions.RUINS_SCATTERED);
			mars_market.addCondition(Conditions.THIN_ATMOSPHERE);
			mars_market.addCondition(Conditions.ORE_MODERATE);
			mars_market.addCondition(Conditions.RARE_ORE_MODERATE);
			mars_market.addCondition(Conditions.ORGANICS_COMMON);
			mars_market.setPrimaryEntity(mars);
			mars.setMarket(mars_market);

			// Ceres Conditions

			// Jupiter Conditions

				// Io Conditions 225 Hazard Rating
				MarketAPI io_market = Global.getFactory().createMarket("io_market", io.getName(), 0);
				io_market.setPlanetConditionMarketOnly(true);
				io_market.addCondition(Conditions.TECTONIC_ACTIVITY);
				io_market.addCondition(Conditions.POOR_LIGHT);
				io_market.addCondition(Conditions.HOT);
				io_market.addCondition(Conditions.THIN_ATMOSPHERE);
				io_market.addCondition(Conditions.LOW_GRAVITY);
				io_market.addCondition(Conditions.ORE_ABUNDANT);
				io_market.addCondition(Conditions.RARE_ORE_ABUNDANT);
				io_market.setPrimaryEntity(io);
				io.setMarket(io_market);

				// Europa Conditions 200 Hazard Rating
				MarketAPI europa_market = Global.getFactory().createMarket("europa_market", europa.getName(), 0);
				europa_market.setPlanetConditionMarketOnly(true);
				europa_market.addCondition(Conditions.VOLATILES_PLENTIFUL);
				europa_market.addCondition(Conditions.ORGANICS_ABUNDANT);
				europa_market.addCondition(Conditions.THIN_ATMOSPHERE);
				europa_market.addCondition(Conditions.COLD);
				europa_market.addCondition(Conditions.POOR_LIGHT);
				europa_market.addCondition(Conditions.LOW_GRAVITY);
				europa_market.setPrimaryEntity(europa);
				europa.setMarket(europa_market);

				// Ganymede Conditions 200 Hazard Rating
				MarketAPI ganymede_market = Global.getFactory().createMarket("ganymede_market", ganymede.getName(), 0);
				ganymede_market.setPlanetConditionMarketOnly(true);
				ganymede_market.addCondition(Conditions.COLD);
				ganymede_market.addCondition(Conditions.POOR_LIGHT);
				ganymede_market.addCondition(Conditions.THIN_ATMOSPHERE);
				ganymede_market.addCondition(Conditions.LOW_GRAVITY);
				ganymede_market.addCondition(Conditions.ORE_MODERATE);
				ganymede_market.addCondition(Conditions.RARE_ORE_MODERATE);
				ganymede_market.addCondition(Conditions.VOLATILES_ABUNDANT);
				ganymede_market.setPrimaryEntity(ganymede);
				ganymede.setMarket(ganymede_market);

				// Callisto 225 Hazard Rating
				MarketAPI callisto_market = Global.getFactory().createMarket("callisto_market", callisto.getName(), 0);
				callisto_market.setPlanetConditionMarketOnly(true);
				callisto_market.addCondition(Conditions.COLD);
				callisto_market.addCondition(Conditions.POOR_LIGHT);
				callisto_market.addCondition(Conditions.LOW_GRAVITY);
				callisto_market.addCondition(Conditions.NO_ATMOSPHERE);
				callisto_market.addCondition(Conditions.ORE_ABUNDANT);
				callisto_market.addCondition(Conditions.RARE_ORE_ABUNDANT);
				callisto_market.addCondition(Conditions.VOLATILES_ABUNDANT);
				callisto_market.setPrimaryEntity(callisto);
				callisto.setMarket(callisto_market);


			// Saturn Conditions

				// Enceladus Conditions 225 Hazard Rating
				MarketAPI enceladus_market = Global.getFactory().createMarket("enceladus_market", enceladus.getName(), 0);
				enceladus_market.setPlanetConditionMarketOnly(true);
				enceladus_market.addCondition(Conditions.LOW_GRAVITY);
				enceladus_market.addCondition(Conditions.VERY_COLD);
				enceladus_market.addCondition(Conditions.TECTONIC_ACTIVITY);
				enceladus_market.addCondition(Conditions.POOR_LIGHT);
				enceladus_market.addCondition(Conditions.VOLATILES_DIFFUSE);
				enceladus_market.setPrimaryEntity(enceladus);
				enceladus.setMarket(enceladus_market);

				// Titan Conditions 200
				MarketAPI titan_market = Global.getFactory().createMarket("titan_market", titan.getName(), 0);
				titan_market.setPlanetConditionMarketOnly(true);
				titan_market.addCondition(Conditions.VOLATILES_PLENTIFUL);
				titan_market.addCondition(Conditions.ORE_MODERATE);
				titan_market.addCondition(Conditions.RARE_ORE_MODERATE);
				titan_market.addCondition(Conditions.ORGANICS_COMMON);
				titan_market.addCondition(Conditions.COLD);
				titan_market.addCondition(Conditions.POOR_LIGHT);
				titan_market.addCondition(Conditions.INIMICAL_BIOSPHERE);
				titan_market.addCondition(Conditions.RUINS_SCATTERED);
				titan_market.setPrimaryEntity(titan);
				titan.setMarket(titan_market);

			// Uranus Conditions

				// Oberon Conditions

			// Neptune Conditions

				// Triton Conditions

		}
    }
}
