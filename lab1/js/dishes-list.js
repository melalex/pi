class DishesList {

    constructor() {
        this.dishes = [];
        this.dishesLayout = "#dishes";
        this.descriptionLayout = "#description";

        this.loadContent = this.loadContent.bind(this);
        this.render = this.render.bind(this);

        window.onload = this.loadContent;
    }

    loadContent() {
        console.log("DishesList loadContent call");

        let self = this;

        $.getJSON("data/dishes.json")
            .done(function (data) {
                self.dishes = data.map(o => new Dish(o.name, o.description, self.dishesLayout, self.descriptionLayout));
            })
            .always(this.render);
    }

    render() {
        console.log("DishesList render call");

        this.dishes.forEach(d => d.render())
    }
}

dishesList = new DishesList();
