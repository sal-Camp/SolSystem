package data.scripts;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.*;
import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.impl.campaign.ids.Terrain;
import com.fs.starfarer.combat.entities.terrain.Planet;

import java.awt.*;

public class SolSystem_modPlugin extends BaseModPlugin {
    @Override
    public void onNewGame() {

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
		array.setCircularOrbitPointingDown(star, 220, 7000, 400);

		//Gate
		SectorEntityToken sol_gate = system.addCustomEntity("sol_gate",
				 "Sol Gate",
				 "inactive_gate",
				 null);
		sol_gate.setCircularOrbit(star, 120, 7000, 400);

		//Mercury
		PlanetAPI mercury = system.addPlanet("mercury", star, "Mercury", "rocky_metallic", 0, 60, 1500, 88);
		/*MarketAPI mercury_market = Global.getFactory().createMarket("mercury_market", mercury.getName(), 0);
		mercury_market.setPlanetConditionMarketOnly(true);
		mercury_market.addCondition(Conditions.HOT);
		mercury_market.addCondition(Conditions.TOXIC_ATMOSPHERE);
		mercury_market.addCondition(Conditions.LOW_GRAVITY);
		mercury_market.addCondition(Conditions.ORE_ULTRARICH);
		mercury_market.addCondition(Conditions.RARE_ORE_ULTRARICH);
		mercury_market.setPrimaryEntity(mercury);
		mercury.setMarket(mercury_market);*/

		//Venus
		PlanetAPI venus = system.addPlanet("venus", star, "Venus", "rocky_metallic", 0, 140, 2200, 225);
		/*MarketAPI venus_market = Global.getFactory().createMarket("venus_market", venus.getName(), 0);
		venus_market.addCondition(Conditions.VERY_HOT);
		venus_market.addCondition(Conditions.DENSE_ATMOSPHERE);
		venus_market.addCondition(Conditions.ORE_ULTRARICH);
		venus_market.addCondition(Conditions.RARE_ORE_ULTRARICH);
		venus_market.setPrimaryEntity(venus);
		venus.setMarket(venus_market);*/

		//Terra
		PlanetAPI terra = system.addPlanet("terra", star, "Terra", "terran", 0, 180, 3400, 365);
		/*MarketAPI terra_market = Global.getFactory().createMarket("terra_market", terra.getName(), 0);
		terra_market.addCondition(Conditions.HABITABLE);
		terra_market.addCondition(Conditions.FARMLAND_BOUNTIFUL);
		terra_market.addCondition(Conditions.ORE_SPARSE);
		terra_market.addCondition(Conditions.RARE_ORE_SPARSE);
		terra_market.addCondition(Conditions.RUINS_VAST);
		terra_market.addCondition(Conditions.ORGANICS_PLENTIFUL);
		terra_market.addCondition(Conditions.DECIVILIZED);
		terra_market.setPrimaryEntity(terra);
		terra.setMarket(terra_market);*/

			//Luna
			PlanetAPI luna = system.addPlanet("luna", terra, "Luna","barren", 0,40, 350, 30);

		//Mars
		PlanetAPI mars = system.addPlanet("mars", star, "Mars", "desert", 0, 80, 5000, 500);
		/*MarketAPI  mars_market = Global.getFactory().createMarket("mars_market", mars.getName(), 0);
		mars_market.addCondition(Conditions.RUINS_SCATTERED);
		mars_market.addCondition(Conditions.THIN_ATMOSPHERE);
		mars_market.addCondition(Conditions.ORE_MODERATE);
		mars_market.addCondition(Conditions.RARE_ORE_MODERATE);
		mars_market.addCondition(Conditions.ORGANICS_COMMON);
		mars_market.setPrimaryEntity(mars);
		mars.setMarket(mars_market);*/

		//Asteroid Belt
		system.addAsteroidBelt(star, 1000, 6000, 500, 150, 300, Terrain.ASTEROID_BELT, "Asteroid Belt");
		system.addRingBand(star, "misc", "rings_asteroids0", 256f, 4, Color.white,256f,6000,295f,Terrain.ASTEROID_BELT,"Asteroid Belt1");

		//Asteroid Belt Jump Point
		JumpPointAPI asteroid_belt_jump_point = Global.getFactory().createJumpPoint("sol_jump", "Sol Jump-Point");
		asteroid_belt_jump_point.setCircularOrbit(system.getEntityById("sol"), 245, 7000, 200);
		asteroid_belt_jump_point.setStandardWormholeToHyperspaceVisual();
		system.addEntity(asteroid_belt_jump_point);

		//Jupiter
		PlanetAPI jupiter = system.addPlanet("jupiter", star, "Jupiter", "gas_giant", 30, 500, 8800, 800);
		/*MarketAPI jupiter_market = Global.getFactory().createMarket("jupiter_market", jupiter.getName(), 0);
		jupiter_market.addCondition(Conditions.HIGH_GRAVITY);
		jupiter_market.setPrimaryEntity(jupiter);
		jupiter.setMarket(jupiter_market);*/

			//Europa
			PlanetAPI europa = system.addPlanet("europa", jupiter, "Europa", "frozen", 0, 40, 625, 30);
			/*MarketAPI europa_market = Global.getFactory().createMarket("europa_market", europa.getName(), 0);
			europa_market.addCondition(Conditions.ORGANICS_PLENTIFUL);
			europa_market.setPrimaryEntity(europa);
			europa.setMarket(europa_market);*/

			//Io
			PlanetAPI io = system.addPlanet("io", jupiter, "Io", "lava", 120,50, 1000, 45);
			/*MarketAPI io_market = Global.getFactory().createMarket("io_market", io.getName(), 0);
			io_market.addCondition(Conditions.EXTREME_TECTONIC_ACTIVITY);
			io_market.setPrimaryEntity(io);
			io.setMarket(io_market);*/

			//Ganymede
			PlanetAPI ganymede = system.addPlanet("ganymede", jupiter, "Ganymede", "rocky_ice", 240, 60, 1200, 60);

			//Jupiter's Belt
			system.addRingBand(jupiter, "misc", "rings_ice0", 256f, 2, Color.white, 256f, 800, 45, Terrain.RING, "Jupiter's Belt");

		//Saturn
		PlanetAPI saturn = system.addPlanet("saturn", star, "Saturn", "gas_giant", 180, 425, 13000, 1200);

			//Titan
			PlanetAPI titan = system.addPlanet("titan", saturn, "Titan", "cryovolcanic", 0, 55, 1000, 60);
			/*MarketAPI titan_market = Global.getFactory().createMarket("titan_market", titan.getName(), 0);
			titan_market.addCondition(Conditions.VOLATILES_PLENTIFUL);
			titan_market.setPrimaryEntity(titan);
			titan.setMarket(titan_market);*/

			//Enceladus
			PlanetAPI enceladus = system.addPlanet("enceladus", saturn, "Enceladus", "frozen", 180, 10, 475, 30);

			//Saturn's Belt
			system.addRingBand(saturn, "misc", "rings_ice0", 256f, 2, Color.white, 256f, 630, 45, Terrain.RING, "Saturn's Belt");

		//Uranus
		PlanetAPI uranus = system.addPlanet("uranus", star, "Uranus", "ice_giant", 90, 350, 17000, 1500);

			//Oberon
			PlanetAPI oberon = system.addPlanet("oberon", uranus, "Oberon", "rocky_ice", 0, 40, 900, 60);

			//Uranus' Belt
			system.addRingBand(uranus, "misc", "rings_ice0", 256f, 2, Color.white, 256f, 550, 45, Terrain.RING, "Uranus' Belt");

		//Neptune
		PlanetAPI neptune = system.addPlanet("neptune", star, "Neptune", "ice_giant", 270, 340, 21000, 1800);

			//Triton
			PlanetAPI triton = system.addPlanet("triton", neptune, "Triton", "cryovolcanic", 0, 50, 900, 60);
			/*MarketAPI triton_market = Global.getFactory().createMarket("triton_market", triton.getName(), 0);
			triton_market.addCondition(Conditions.THIN_ATMOSPHERE);
			triton_market.addCondition(Conditions.METEOR_IMPACTS);
			triton_market.addCondition(Conditions.VERY_COLD);
			triton_market.setPrimaryEntity(triton);
			triton.setMarket(triton_market);*/

			//Neptune's Belt
			system.addRingBand(neptune, "misc", "rings_ice0", 256f, 2, Color.white, 256f, 500, 45, Terrain.RING, "Neptune's Belt");

		//Kuiper Belt
		system.addAsteroidBelt(star, 1000, 25000, 1000, 150, 300, Terrain.ASTEROID_BELT, "Kuiper Belt");
		system.addRingBand(star, "misc", "rings_dust0", 256f, 3, Color.white, 256f, 25000, 305f, Terrain.ASTEROID_BELT,"Kuiper Belt1");
		system.addRingBand(star, "misc", "rings_asteroids0", 256f, 3, Color.white,256f,25000,295f,Terrain.ASTEROID_BELT,"Kuiper Belt2");

		system.autogenerateHyperspaceJumpPoints(true,true);
    }
}
