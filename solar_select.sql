use solar;

select  name, area_coverage from installer_company where area_coverage > 45;

select MIN(cost), name from installer_company as install_comp join installation as inst on inst.id=install_comp.id;

select id, (production - consumption) as efficiency from efficiency;

select * from efficiency where current_timing between '2022-09-06 ' and '2022-09-25 ';

select  IP_address from battery where capacity > 47;

select  id, energy_sold*feed_in_tariff as income from solar_system;

select name, solar_system_id from client as c join client_solar as cs on cs.id = c.id;

SELECT solar_panel_id, COUNT(solar_panel_id) FROM devices GROUP BY solar_panel_id HAVING COUNT(solar_panel_id) > 2;

select min(low_rate_tariff) from time_slots_with_low_rate_tariff;

select * from solar_system where house_fuse is true;