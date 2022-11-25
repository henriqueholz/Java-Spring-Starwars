package org.starwars.api.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {
        @Id
        private Long id;

        private String cargo_capacity;

        private String model;

        private String name;

        private String consumables;

        private String cost_in_credits;

        private String created;

        private String crew;

        private String edited;

        private String length;

        private String manufacturer;

        private String max_atmosphering_speed;

        private String passengers;

        private String[] pilots;

        private String[] films;

        private String url;

        private String vehicle_class;

        public Vehicle(String cargo_capacity, String model, String name, String consumables, String cost_in_credits, String created, String crew, String edited, String length, String manufacturer, String max_atmosphering_speed, String passengers, String[] pilots, String[] films, String url, String vehicle_class) {
                this.cargo_capacity = cargo_capacity;
                this.model = model;
                this.name = name;
                this.consumables = consumables;
                this.cost_in_credits = cost_in_credits;
                this.created = created;
                this.crew = crew;
                this.edited = edited;
                this.length = length;
                this.manufacturer = manufacturer;
                this.max_atmosphering_speed = max_atmosphering_speed;
                this.passengers = passengers;
                this.pilots = pilots;
                this.films = films;
                this.url = url;
                this.vehicle_class = vehicle_class;
        }

        public String getCargo_capacity() {
                return cargo_capacity;
        }

        public String getModel() {
                return model;
        }

        public String getName() {
                return name;
        }

        public String getConsumables() {
                return consumables;
        }

        public String getCost_in_credits() {
                return cost_in_credits;
        }

        public String getCreated() {
                return created;
        }

        public String getCrew() {
                return crew;
        }

        public String getEdited() {
                return edited;
        }

        public String getLength() {
                return length;
        }

        public String getManufacturer() {
                return manufacturer;
        }

        public String getMax_atmosphering_speed() {
                return max_atmosphering_speed;
        }

        public String getPassengers() {
                return passengers;
        }

        public String[] getPilots() {
                return pilots;
        }

        public String[] getFilms() {
                return films;
        }

        public String getUrl() {
                return url;
        }

        public String getVehicle_class() {
                return vehicle_class;
        }

        public void setCargo_capacity(String cargo_capacity) {
                this.cargo_capacity = cargo_capacity;
        }

        public void setModel(String model) {
                this.model = model;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setConsumables(String consumables) {
                this.consumables = consumables;
        }

        public void setCost_in_credits(String cost_in_credits) {
                this.cost_in_credits = cost_in_credits;
        }

        public void setCreated(String created) {
                this.created = created;
        }

        public void setCrew(String crew) {
                this.crew = crew;
        }

        public void setEdited(String edited) {
                this.edited = edited;
        }

        public void setLength(String length) {
                this.length = length;
        }

        public void setManufacturer(String manufacturer) {
                this.manufacturer = manufacturer;
        }

        public void setMax_atmosphering_speed(String max_atmosphering_speed) {
                this.max_atmosphering_speed = max_atmosphering_speed;
        }

        public void setPassengers(String passengers) {
                this.passengers = passengers;
        }

        public void setPilots(String[] pilots) {
                this.pilots = pilots;
        }

        public void setFilms(String[] films) {
                this.films = films;
        }

        public void setUrl(String url) {
                this.url = url;
        }

        public void setVehicle_class(String vehicle_class) {
                this.vehicle_class = vehicle_class;
        }
}
