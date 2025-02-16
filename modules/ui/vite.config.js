import { sveltekit } from '@sveltejs/kit/vite';
import {viteStaticCopy} from "vite-plugin-static-copy";

/** @type {import('vite').UserConfig} */
const config = {
	plugins: [
		sveltekit(),
		viteStaticCopy({
			targets: [
				{
					src: 'src/lib/assets/styles/themes',
					dest: '_app/immutable/assets'
				}
			]
		})
	]
};

export default config;
