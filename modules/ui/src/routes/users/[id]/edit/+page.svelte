<script lang="ts">
    import {page} from '$app/stores';

    import {UserService} from "$lib/services/UserService";
    import O_userEdition from "$lib/components/organisms/O_user/O_userEdition.svelte";

    let userPromise

    $: if($page.params?.id) {
        userPromise = UserService.byId($page.params.id);
    }
</script>

{#await userPromise}
    <p>...waiting</p>
{:then user}
    <O_userEdition {user}/>
{:catch error}
    <p style="color: red">User not found !</p>
{/await}